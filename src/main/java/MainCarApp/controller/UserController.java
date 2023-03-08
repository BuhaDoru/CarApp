package MainCarApp.controller;


import MainCarApp.model.User;
import MainCarApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RestController
@RequestMapping(path ="/carApp")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ModelAndView redirectPostToPost(User newUser) {
        userService.saveUser(newUser);
        return new ModelAndView("redirect:/register_message.html");
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllusers();
    }

    @DeleteMapping(path="/remove/{id}")
    public void deleteUser(@PathVariable Integer id) {
        User user = userService.deleteById(id);
    }

    @PostMapping(path="/login/{email}/{password}")
    public ModelAndView findByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
        User user = userService.findByEmailAndPassword(email, password);
        System.out.println("emai:" + email + "password:" + password );
        if (user != null)
            return new ModelAndView("redirect:/user_main_page.html");
        else return new ModelAndView("redirect:/home_page.html");
    }
}
