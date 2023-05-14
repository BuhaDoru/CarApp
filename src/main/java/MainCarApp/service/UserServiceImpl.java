package MainCarApp.service;

import MainCarApp.dto.UserDto;
import MainCarApp.model.Role;
import MainCarApp.model.User;
import MainCarApp.repository.RoleRepository;
import MainCarApp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_USER");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        String[] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        String rols = "";
        for (Role role:user.getRoles()) {
            rols += role.getName() + " ";
        }
        userDto.setRole(rols);
        return userDto;
    }

    private Role checkRoleExist(){
        List<Role> roles = new ArrayList<>();

        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        roles.add(adminRole);

        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        roles.add(userRole);

        return (Role) roleRepository.saveAll(roles);
    }
     @Override
    public void deleteUserById(Long userId) {
         Optional<User> user = userRepository.findById(userId);
         if (user.isPresent()) {
             userRepository.deleteById(userId);
         }
     }

    @Override
    @Transactional
    public void changeUserRole(String email, String role) {
        User user = userRepository.findByEmail(email);
        user.getRoles().remove(0);
        Role rol = roleRepository.findByName(role);
        user.getRoles().add(rol);
        userRepository.save(user);
    }
}