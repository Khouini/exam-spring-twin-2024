package khouini.yacine.examenspring.repositories;

import khouini.yacine.examenspring.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle, Long> {
}
