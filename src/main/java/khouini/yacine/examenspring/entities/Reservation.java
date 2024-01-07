package khouini.yacine.examenspring.entities;
import jakarta.persistence.*;
import lombok.*;

import java.nio.file.WatchService;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timereservation;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Worker worker;

    @ManyToMany
    List<WashingService> washingServices;
}
