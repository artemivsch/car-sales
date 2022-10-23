package by.tms.carsales.repository;

import by.tms.carsales.entity.car.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<CarModel, Long> {
}
