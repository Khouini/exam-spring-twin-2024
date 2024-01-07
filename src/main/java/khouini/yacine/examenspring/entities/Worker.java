package khouini.yacine.examenspring.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nic;

    @OneToMany(mappedBy = "worker", fetch = FetchType.EAGER)
    List<Reservation> reservations;
}
