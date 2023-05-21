package MainCarApp.repository.userService;

import MainCarApp.model.userModel.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}