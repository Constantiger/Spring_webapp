package com.example.webapp.controller;

import com.example.webapp.domain.User;
import com.example.webapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserAdministrationController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/user/{id}")
    public Optional<User> show(@RequestParam Long id) {
        return userServiceImpl.getUserById(id);
    }

    @GetMapping("/user")
    public Iterable<User> showAll() {
        return userServiceImpl.getUsers();
    }

    @PostMapping("/registration")
    public User addUser(@RequestParam(value = "username") String username,
                        @RequestParam (value = "password") String password,
                        @RequestParam (value = "email") String email) {
        return userServiceImpl.createUser(username, password, email);
    }

    @DeleteMapping("/user/{id}")
    public User deleteUser(@RequestParam Long id) {
        return userServiceImpl.deleteUser(id);
    }
}
