package MainCarApp.controller;

import MainCarApp.model.Car;
import MainCarApp.model.CarModel;
import MainCarApp.service.CarDocumentsService;
import MainCarApp.service.CarModelService;
import MainCarApp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarDocuments {

    @Autowired
    private CarService carService;
    private CarModelService carModelService;
    private CarDocumentsService carDocumentsService;

    public CarDocuments(CarService carservice, CarModelService carModelService, CarDocumentsService carDocumentsService) {
        this.carService = carservice;
        this.carModelService = carModelService;
        this.carDocumentsService = carDocumentsService;
    }

    @GetMapping("/allCars")
    public String showCars(Model model) {
        List<Car> allCars = carService.getAllCars();
        List<CarModel> allCarModels = carModelService.getAllCarModels();
        model.addAttribute("allCars", allCars);
        model.addAttribute("allCarsModel", allCarModels);
        return "user_main_page";
    }

    @GetMapping("/documents/add")
    public String addDocuments(@RequestParam String Vinieta, @RequestParam String Asigurare, @RequestParam String ITP, @RequestParam String NrInmatriculare, @RequestParam String CarModel) {
        carDocumentsService.addCarDocuments(ITP, Asigurare, Vinieta, NrInmatriculare, CarModel);
        return "/user_main_page";
    }
}
