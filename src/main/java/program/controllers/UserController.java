package program.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import program.entities.User;
import program.repositories.UserRepository;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

@Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/")
    public List<User> index(){
        return userRepository.findAll();
    }
}
