package khouini.yacine.examenspring.services;

import khouini.yacine.examenspring.entities.*;
import khouini.yacine.examenspring.repositories.ReservationRepo;
import khouini.yacine.examenspring.repositories.VehicleRepo;
import khouini.yacine.examenspring.repositories.WashingServiceRepo;
import khouini.yacine.examenspring.repositories.WorkerRepo;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class ResaService implements IResaService {
    private final VehicleRepo vehicleRepo;
    private final WashingServiceRepo washingServiceRepo;
    private final ReservationRepo reservationRepo;
    private final WorkerRepo workerRepo;
    private static final Logger log = LoggerFactory.getLogger(ResaService.class);

    @Override
    public Vehicle addVehicleResaAndAffectToXassingService(Vehicle vehicle, List<Long> idServices) {
        List<WashingService> washingServices = new ArrayList<>();

        for (long idService : idServices) {
            WashingService washingServiceInstance = washingServiceRepo.findById(idService).orElse(null);
            if (washingServiceInstance == null) {
                throw new RuntimeException("wasing service with id : " + idService + " not found");
            }
            washingServices.add(washingServiceInstance);
        }
        Reservation reservation = new Reservation();
        reservation.setTimereservation(LocalDateTime.now().plusHours(2));
        System.out.println("washing services: " + washingServices);
        reservation.setWashingServices(washingServices);
        reservation.setStatus(Status.PENDING);
        Reservation savedResa = reservationRepo.save(reservation);
        System.out.println("saved resa: " + savedResa);
        List<Reservation> reservations = new ArrayList<>();
        reservations.add(savedResa);


        vehicle.setReservations(reservations);

        System.out.println("vehicle to save: " + vehicle);
        Vehicle savedVehicle = vehicleRepo.save(vehicle);
        System.out.println("saved vehicle:" + savedVehicle);
        vehicle.setReservations(null);

        return vehicle;
    }

    @Override
    public Float calculateTotalIncomePerWorker(String name, Type typeService) {
        Worker worker = workerRepo.findWorkerByName(name);
        if (worker == null) {
            throw new RuntimeException("Worker not found");
        }
        float rs = 0;
        for (Reservation reservation : worker.getReservations()) {
            if (reservation.getStatus() == Status.CONFIRMED && reservation.getTimereservation().isAfter(LocalDateTime.now().minusMonths(1))) {
                for (WashingService ws : reservation.getWashingServices()) {
                    if (ws.getType() == typeService) {
                        rs += 1;
                    }
                }
            }
        }
        return rs;
    }

    @Override
    public Map<String, Long> getListServiceAndNbResa() {
        return null;
    }

    @Override
    public Worker addWorkerToReservation(String nic, List<Long> idReservation) {
        Worker worker = workerRepo.findWorkerByNic(nic);
        if (worker == null) {
            throw new RuntimeException("Work not found");


        }
        if (worker.getReservations().stream().filter(resa -> resa.getStatus() == Status.CONFIRMED).toList().size() > 5) {
            throw new RuntimeException("Max reservation atteint 5");
        }

        for (long idResa:idReservation ){
            Reservation resa = reservationRepo.findById(idResa).orElse(null);
            resa.setStatus(Status.CONFIRMED);
            resa.setWorker(worker);
            reservationRepo.save(resa);
        }
        return worker;
    }

    @Scheduled(fixedRate = 15000)
    public void getResas() {
        log.info("pending resas:");

        for (Reservation reservation : reservationRepo.findAll()) {
            if (reservation.getStatus() == Status.PENDING) {
                log.info("reservation " + reservation.getId() + " at " + reservation.getTimereservation());
            }
        }
    }
}
