package khouini.yacine.examenspring.services;

import khouini.yacine.examenspring.entities.Type;
import khouini.yacine.examenspring.entities.Vehicle;
import khouini.yacine.examenspring.entities.Worker;

import java.util.List;
import java.util.Map;

public interface IResaService {
    public Vehicle addVehicleResaAndAffectToXassingService(Vehicle vehicle, List<Long> idService);

    public Float calculateTotalIncomePerWorker(String name, Type typeService);

    public Map<String, Long> getListServiceAndNbResa();
    public Worker addWorkerToReservation(String nic, List<Long> idReservation);
}
