package MainCarApp.service;

import MainCarApp.model.CarDocuments;
import MainCarApp.repository.CarDocumentsRepository;
import MainCarApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarDocumentsService {

    private final CarDocumentsRepository carDocumentsRepository;

    private final UserRepository userRepository;

    public CarDocumentsService(CarDocumentsRepository carDocumentsRepository, UserRepository userRepository) {
        this.carDocumentsRepository = carDocumentsRepository;
        this.userRepository = userRepository;
    }

     public List<CarDocuments> getAllCarDocuments() {
        return carDocumentsRepository.findAll();
     }
}
