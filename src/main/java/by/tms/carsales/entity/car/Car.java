package by.tms.carsales.entity.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Year;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int yearOfMade;

    private double volumeOfEngine;

    private int runKm;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "model_id")
    private CarModel carModel;

    private String number;


}
