package khouini.yacine.examenspring.services;

import khouini.yacine.examenspring.entities.Worker;
import khouini.yacine.examenspring.repositories.WorkerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WorkerService implements IWorkerService {
    final private WorkerRepo workerRepo;
    @Override
    public Worker addWorker(Worker worker) {
        return workerRepo.save(worker);
    }
}
