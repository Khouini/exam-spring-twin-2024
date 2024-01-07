package khouini.yacine.examenspring.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class WashingService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float price;
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToMany(mappedBy = "washingServices", fetch = FetchType.EAGER)
    List<Reservation> reservations;
}
