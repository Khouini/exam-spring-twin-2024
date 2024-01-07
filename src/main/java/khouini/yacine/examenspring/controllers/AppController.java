package khouini.yacine.examenspring.controllers;

import khouini.yacine.examenspring.entities.Type;
import khouini.yacine.examenspring.entities.Vehicle;
import khouini.yacine.examenspring.entities.WashingService;
import khouini.yacine.examenspring.entities.Worker;
import khouini.yacine.examenspring.services.IAppService;
import khouini.yacine.examenspring.services.IResaService;
import khouini.yacine.examenspring.services.IWashingService;
import khouini.yacine.examenspring.services.IWorkerService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.mapping.Map;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("restApp")
@AllArgsConstructor
public class AppController {
    private final IAppService appService;
    private final IWorkerService workerService;
    private final IWashingService washingServiceService;
    private final IResaService resaService;

    @GetMapping("test")
    public String test() {
        return appService.test();
    }


    @PostMapping("addWorker")
    public Worker addWorker(Worker worker) {
        return workerService.addWorker(worker);
    }

    @PostMapping("addWashingServices")
    public String addWashingService(@RequestBody List<WashingService> washingServices) {
        washingServiceService.addWashingService(washingServices);
        return "success";
    }

    @PostMapping("addVehicleResaAndAffectToXassingService/{idService}")
    public Vehicle addVehicleResaAndAffectToXassingService(@RequestBody Vehicle vehicle, @PathVariable long idService) {
        //Vehicle vehicle, List<Long> idServices
        List<Long> idservices = new ArrayList<>();
        idservices.add(idService);
        System.out.println("id services: " + idservices);
        return resaService.addVehicleResaAndAffectToXassingService(vehicle, idservices);
    }

    @GetMapping("calculateTotalIncomePerWorker/{name}/{typeService}")
    public Float calculateTotalIncomePerWorker(@PathVariable String name, @PathVariable String typeService) {
        Type type = Type.valueOf(typeService);
        return resaService.calculateTotalIncomePerWorker(name, type);

    }

    @PutMapping("addWorkerToReservation/{nic}")
    public Worker addWorkerToReservation(@PathVariable String nic, @RequestBody List<Long> idReservations) {
        return resaService.addWorkerToReservation(nic, idReservations);
    }
}
