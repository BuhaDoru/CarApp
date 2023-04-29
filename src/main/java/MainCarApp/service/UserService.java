package MainCarApp.service;

import MainCarApp.dto.UserDto;
import MainCarApp.model.User;



import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();

    void deleteUserById(Long userId);

    void changeUserRole(String email, String roleName);

}
