package by.tms.carsales.controller;

import by.tms.carsales.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {

    @Autowired
    private UserRepository userRepository;
}
