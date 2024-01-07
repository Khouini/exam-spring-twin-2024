package khouini.yacine.examenspring.services;

import khouini.yacine.examenspring.entities.WashingService;
import khouini.yacine.examenspring.repositories.WashingServiceRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WashingServiceServic implements IWashingService {
    final private WashingServiceRepo washingServiceRepo;
    @Override
    public void addWashingService(List<WashingService> washingServices) {
        washingServiceRepo.saveAll(washingServices);
    }
}
