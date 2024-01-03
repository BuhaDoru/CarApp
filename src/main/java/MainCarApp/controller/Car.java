package MainCarApp.controller;

import MainCarApp.model.CarModel;
import MainCarApp.service.CarModelService;
import org.springframework.ui.Model;
import MainCarApp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Car {

    @Autowired
    private CarService carService;
    private CarModelService carModelService;

    public Car(CarService carservice, CarModelService carModelService) {
        this.carService = carservice;
        this.carModelService = carModelService;
    }


    @GetMapping("/cars")
    public String showCarModels(Model model) {
        List<MainCarApp.model.Car> cars = carService.getAllCars();
        List<CarModel> carModels = carModelService.getAllCarModels();
        model.addAttribute("cars", cars);
        model.addAttribute("carModels", carModels);
        return "cars";
    }

        @PostMapping("/Car/add")
    public String addCar(@RequestParam("carName") String carName) {
        carService.addCar(carName);
        return "redirect:/cars";
    }

    @PostMapping("/Car/delete")
    public String deleteCar(@RequestParam("carId") Long carId) {
        carService.deleteCar(carId);
        return "redirect:/cars";
    }
}
