package MainCarApp.service;

import MainCarApp.model.User;
import java.util.List;

public interface UserService {

    public User saveUser(User user);

   public User deleteById(Integer id);

   public List<User> getAllusers();

   public User findByEmailAndPassword(String email, String password);

}
