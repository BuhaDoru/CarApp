package MainCarApp.controller;

import MainCarApp.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarModel {

    @Autowired
    private CarModelService carModelService;

    public CarModel(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    @PostMapping("/CarModel/add")
    public String addModel(@RequestParam("carId") Long carId, @RequestParam("modelName") String modelName) {
        carModelService.addModel(carId, modelName);
        return "redirect:/cars";
    }

    @PostMapping("/CarModel/delete")
    public String deleteModel(@RequestParam("modelId") Long modelId) {
        carModelService.deleteModel(modelId);
        return "redirect:/cars";
    }
}
