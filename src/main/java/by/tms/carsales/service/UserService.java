package by.tms.carsales.service;

import by.tms.carsales.entity.User;
import by.tms.carsales.model.RegistrationUserModel;
import by.tms.carsales.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(RegistrationUserModel userModel){
        User user = new User();
        user.setName(userModel.getName());
        user.setUsername(userModel.getUsername());
        user.setPassword(userModel.getPassword());
        user.setRegistrationDate(LocalDate.now());
        user.setIsAdmin(false);
        userRepository.save(user);
    }



    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}