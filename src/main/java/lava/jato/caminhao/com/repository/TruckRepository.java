package lava.jato.caminhao.com.repository;

import lava.jato.caminhao.com.model.Truck;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface TruckRepository extends JpaRepository<Truck, String>{

    Optional<Truck> findByTruckPlate(String truck_plate);
}

