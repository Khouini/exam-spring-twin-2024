package khouini.yacine.examenspring.repositories;

import khouini.yacine.examenspring.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepo extends JpaRepository<Worker, Long> {
    Worker findWorkerByName(String name);

    Worker findWorkerByNic(String nic);
}
