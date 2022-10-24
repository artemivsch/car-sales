package by.tms.carsales.entity;

import by.tms.carsales.entity.car.Car;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int coast;

    @OneToOne(cascade = CascadeType.ALL)
    private Car car;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "user_id")
    private User user;

    private LocalDate date;

    @Lob
    private String file64;
}
