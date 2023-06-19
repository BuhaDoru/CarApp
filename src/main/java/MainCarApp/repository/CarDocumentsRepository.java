package MainCarApp.repository;

import MainCarApp.model.CarDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CarDocumentsRepository extends JpaRepository<CarDocuments, Long> {
}
