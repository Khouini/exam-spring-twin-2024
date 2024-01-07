package khouini.yacine.examenspring.repositories;

import khouini.yacine.examenspring.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {
}
