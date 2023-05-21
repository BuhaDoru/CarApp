package MainCarApp.repository.carService;

import MainCarApp.model.carModel.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel,Long> {
}
