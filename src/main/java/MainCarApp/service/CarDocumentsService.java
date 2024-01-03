package MainCarApp.service;

import MainCarApp.model.CarDocuments;
import MainCarApp.repository.CarDocumentsRepository;
import MainCarApp.repository.CarModelRepository;
import MainCarApp.repository.CarRepository;
import MainCarApp.repository.UserRepository;
import org.springframework.stereotype.Service;
@Service
public class CarDocumentsService {

        private final CarDocumentsRepository carDocumentsRepository;
        private final CarModelRepository carModelRepository;
        private final CarRepository carRepository;
        private final UserRepository userRepository;


    public CarDocumentsService(CarDocumentsRepository carDocumentsRepository, CarModelRepository carModelRepository, CarRepository carRepository, UserRepository userRepository) {
        this.carDocumentsRepository = carDocumentsRepository;
        this.carModelRepository = carModelRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    public void addCarDocuments(String itp, String asigurare, String vinieta, String nrInmatriculare, String carModel) {
        CarDocuments carDocuments = new CarDocuments();
        carDocuments.setItp(itp);
        carDocuments.setAsigurare(asigurare);
        carDocuments.setVinieta(vinieta);
        carDocuments.setNrInmatriculare(nrInmatriculare);
        carDocuments.setCarModel(carModel);
        carDocumentsRepository.save(carDocuments);
    }
}
