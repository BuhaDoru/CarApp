package MainCarApp.service;

import MainCarApp.model.User;
import MainCarApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class UserServiceImp implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteById(Integer id) {
        try {
            userRepository.deleteById(id);
        } catch (DataAccessException e) {
            System.out.println("Nu exista acest id!");
        }
        return null;
    }

    @Override
    public List<User> getAllusers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
       return  userRepository.findByEmailAndPassword(email, password);
    }

}
