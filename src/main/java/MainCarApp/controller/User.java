package MainCarApp.controller;

import MainCarApp.dto.UserDto;
import MainCarApp.model.Car;
import MainCarApp.model.CarModel;
import MainCarApp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class User {

    @Autowired
    private UserService userService;

    public User(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("index")
    public String home(){
        return "index";
    }

    @GetMapping("user_main_page")
    public String userPage() {
        return "user_main_page";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        MainCarApp.model.User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }


    @PostMapping("/user/{userId}/delete")
    public String deleteUserById(@PathVariable("userId") Long userId) {
        userService.deleteUserById(userId);
        return "users";
    }

    @PostMapping("/user/{id}/change-role")
    public String changeUserRole(@PathVariable Long id, @RequestParam String role) {
        userService.changeUserRole(id, role);
        return "users";
    }

    @GetMapping("/loggedUser")
    public String getLoggerUser(Principal principal) {
        return userService.getLoggedUser();
    }

    @PostMapping("/user/addCar")
    public String addUserCar(@RequestParam Long id, @RequestParam Long modelId) {
        userService.addUserCar(id, modelId);
        return "user_main_page";
    }
}
