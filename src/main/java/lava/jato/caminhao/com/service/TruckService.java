package lava.jato.caminhao.com.service;

import lava.jato.caminhao.com.exceptions.TruckNotFoundException;
import lava.jato.caminhao.com.model.Truck;
import lava.jato.caminhao.com.repository.TruckRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class TruckService {

    public static final String ERROR_MESSAGE = "Placa de caminhão não localizada, garanta que essa placa está registrada";
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TruckRepository repo;

    public List<Truck> getAllTrucks() {
        return repo.findAll();
    }

    public Truck addTruck(Truck truck) throws IOException {

        if(repo.findByTruckPlate(truck.getTruckPlate() )!= null)
            return saveTruck(truck);

        throw new IOException("Caminhão já registrado");
    }

    private Truck saveTruck(Truck truck) {
        return repo.save(truck);
    }

    private void adjustNextWashDate(Truck truck) {
        if (truck.getLastWash() != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(truck.getLastWash());
            cal.add(Calendar.DAY_OF_WEEK, 7);
            truck.setNextWash(new Timestamp(cal.getTime().getTime()));
        }
    }

    public Truck updateTruck(String truck_plate, Truck updateTruck) {
        Truck truck = repo.findByTruckPlate(truck_plate).orElseThrow(() -> new TruckNotFoundException(ERROR_MESSAGE));

        String truckCompany = updateTruck.getTruckCompany();
        if (truckCompany != null)
            truck.setTruckCompany(truckCompany);


        String driverName = updateTruck.getDriverName();
        if (driverName != null)
            truck.setDriverName(driverName);


        Timestamp lastWash = updateTruck.getLastWash();
        if (lastWash != null)
            truck.setLastWash(lastWash);

        adjustNextWashDate(truck);

        Timestamp nextWash = updateTruck.getNextWash();
        if (nextWash != null)
            truck.setNextWash(nextWash);

        return saveTruck(truck);
    }

    public void deleteTruck(String truck_plate) {
        Truck truck = repo.findByTruckPlate(truck_plate).orElseThrow(() -> new TruckNotFoundException(ERROR_MESSAGE));
        repo.delete(truck);
    }

    public Truck getByTruckPlate(String truck_plate) {
        return repo.findByTruckPlate(truck_plate).orElseThrow(() -> new TruckNotFoundException(ERROR_MESSAGE));
    }

}
