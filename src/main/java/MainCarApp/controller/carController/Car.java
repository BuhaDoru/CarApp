package MainCarApp.controller.carController;

import org.springframework.ui.Model;
import MainCarApp.model.carModel.CarModel;
import MainCarApp.service.carService.CarService;
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

    public Car(CarService carservice) {
        this.carService = carservice;
    }


    @GetMapping("/cars")
    public String showCarModels(Model model) {
        List<MainCarApp.model.carModel.Car> cars = carService.getAllCars();
        List<CarModel> carModels = carService.getAllCarModels();
        model.addAttribute("cars", cars);
        model.addAttribute("carModels", carModels);
        return "cars";
    }

        @PostMapping("/addCar")
    public String addCar(@RequestParam("carName") String carName) {
        carService.addCar(carName);
        return "redirect:/cars";
    }

    @PostMapping("/deleteCar")
    public String deleteCar(@RequestParam("carId") Long carId) {
        carService.deleteCar(carId);
        return "redirect:/cars";
    }

    @PostMapping("/addModel")
    public String addModel(@RequestParam("carId") Long carId, @RequestParam("modelName") String modelName) {
        carService.addModel(carId, modelName);
        return "redirect:/cars";
    }

    @PostMapping("/deleteModel")
    public String deleteModel(@RequestParam("modelId") Long modelId) {
        carService.deleteModel(modelId);
        return "redirect:/cars";
    }
}
