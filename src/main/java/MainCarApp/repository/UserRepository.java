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
   @Query(value = "DELETE FROM users_roles WHERE user_id = :id", nativeQuery = true)
   void deleteRolesById(@Param("id") Long id);

   @Transactional
   @Modifying
   @Query(value = "DELETE FROM users WHERE id = :id", nativeQuery = true)
   void deleteUserById(@Param("id")Long id);
}
