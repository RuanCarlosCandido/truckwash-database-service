package lava.jato.caminhao.com.controller;

import lava.jato.caminhao.com.model.Truck;
import lava.jato.caminhao.com.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/trucks")
public class TruckController {

    @Autowired
    TruckService truckService;

    @GetMapping()
    public List<Truck> getAllTrucks() {
        return truckService.getAllTrucks();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Truck addTruck(@RequestBody Truck truck) throws IOException {
        return truckService.addTruck(truck);
    }

    @PutMapping("/{truck_plate}")
    public Truck updateTruck(@PathVariable("truck_plate") String truck_plate, @RequestBody Truck updateTruck) {
        return truckService.updateTruck(truck_plate, updateTruck);
    }

    @DeleteMapping("/{truck_plate}")
    public void deleteTruck(@PathVariable("truck_plate") String truck_plate) {
        truckService.deleteTruck(truck_plate);
    }

    @GetMapping("/{truck_plate}")
    public Truck getByTruckPlate(@PathVariable("truck_plate") String truck_plate) {
        return truckService.getByTruckPlate(truck_plate);
    }

    @GetMapping("ping")
    public String ping() throws IOException {
        try (java.net.DatagramSocket socket = new java.net.DatagramSocket()) {
            String publicIP = new java.io.BufferedReader(
                    new java.io.InputStreamReader(new java.net.URL("http://checkip.amazonaws.com/").openStream()))
                    .readLine();
            InetAddress localIP = java.net.InetAddress.getLocalHost();

            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            String ext = socket.getLocalAddress().getHostAddress();

            return "HostService running at: Public IP: " + publicIP + " Local IP: " + localIP + " ext: " + ext;
        }
    }

}
