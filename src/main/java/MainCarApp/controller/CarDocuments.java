package MainCarApp.controller;

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

    @GetMapping("/allCarDocuments")
    public String showCarDocuments(Model model) {
        List<MainCarApp.model.CarDocuments> allCarDocuments = carDocumentsService.getAllCarDocuments();
        model.addAttribute("allCarDocuments", allCarDocuments);
        return "/user_main_page";
    }

    @PostMapping("/documents/add")
    public String addDocuments(@RequestParam ("ITP") String ITP, @RequestParam ("Asigurare") String Asigurare, @RequestParam ("Vinieta") String Vinieta,@RequestParam ("NrInmatriculare")String NrInmatriculare, @RequestParam ("CarModel") String CarModel) {
        carDocumentsService.addCarDocuments(ITP, Asigurare, Vinieta, NrInmatriculare, CarModel);
        return "redirect:/allCarDocuments";
    }

    @PostMapping("/documents/delete")
    public String deleteDocuments(@RequestParam("documentsId") Long documentsId) {
        carDocumentsService.deleteDocuments(documentsId);
        System.out.println(documentsId);
        return "redirect:/allCarDocuments";
    }
}
