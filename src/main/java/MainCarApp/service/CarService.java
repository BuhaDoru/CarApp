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

    public void addCar(String carName) {
        Car car = new Car();
        car.setName(carName);
        carRepository.save(car);
    }

    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }
}