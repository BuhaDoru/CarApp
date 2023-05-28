package MainCarApp.service;

import MainCarApp.model.Car;
import MainCarApp.model.CarModel;
import MainCarApp.repository.CarModelRepository;
import MainCarApp.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarModelService {

    private final CarModelRepository carModelRepository;

    public CarModelService(CarModelRepository carModelRepository) {
        this.carModelRepository = carModelRepository;
    }

    public List<CarModel> getAllCarModels() {
        return carModelRepository.findAll();
    }
    public void addModel(Long carId, String modelName) {
        Optional<CarModel> optionalCar = carModelRepository.findById(carId);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get().getCar();
            boolean modelExists = car.getCarModels().stream()
                    .anyMatch(model -> model.getModel().equals(modelName));

            if (modelExists) {
                System.out.println("This model already exists");
            } else {
                CarModel carModel = new CarModel();
                carModel.setModel(modelName);
                carModel.setCar(car);
                car.getCarModels().add(carModel);
                CarModelRepository.save(car);
            }
        } else {
            System.out.println("This car doesn't exist");
        }
    }

    public void deleteModel(Long modelId) {
        carModelRepository.deleteById(modelId);
    }
}
