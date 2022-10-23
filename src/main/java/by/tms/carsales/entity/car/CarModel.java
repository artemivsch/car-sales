package by.tms.carsales.entity.car;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "models")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany (mappedBy = "carModel", fetch = FetchType.EAGER)
    private List<Car> cars;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "mark_id")
    private Mark mark;



}
