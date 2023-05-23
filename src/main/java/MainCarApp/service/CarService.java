package MainCarApp.service;

import MainCarApp.model.Car;
import MainCarApp.model.CarModel;
import MainCarApp.repository.CarModelRepository;
import MainCarApp.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
        private final CarRepository carRepository;
        private final CarModelRepository carModelRepository;

        public CarService(CarRepository carRepository, CarModelRepository carModelRepository) {
            this.carRepository = carRepository;
            this.carModelRepository = carModelRepository;
        }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<CarModel> getAllCarModels() {
        return carModelRepository.findAll();
    }

    public void addCar(String carName) {
        Car car = new Car();
        car.setName(carName);
        carRepository.save(car);
    }

    public void addModel(Long carId, String modelName) {
        Optional<Car> optionalCar = carRepository.findById(carId);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            boolean modelExists = car.getCarModels().stream()
                    .anyMatch(model -> model.getModel().equals(modelName));

            if (modelExists) {
                System.out.println("This model already exists");
            } else {
                CarModel carModel = new CarModel();
                carModel.setModel(modelName);
                carModel.setCar(car);
                car.getCarModels().add(carModel);
                carRepository.save(car);
            }
        } else {
            System.out.println("This car doesn't exist");
        }
    }

    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }

    public void deleteModel(Long modelId) {
        carModelRepository.deleteById(modelId);
    }
}