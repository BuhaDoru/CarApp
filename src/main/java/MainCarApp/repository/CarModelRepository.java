package MainCarApp.repository;

import MainCarApp.model.Car;
import MainCarApp.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel,Long> {
    static void save(Car car) {
    }
}
