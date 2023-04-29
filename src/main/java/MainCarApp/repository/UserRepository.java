package MainCarApp.repository;

import MainCarApp.model.User;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.SortComparator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

   User findByEmail(String email);

   @Transactional
   @Modifying
   void deleteUserById(Long userId);
}
