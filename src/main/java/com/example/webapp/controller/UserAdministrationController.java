package com.example.webapp.controller;

import com.example.webapp.domain.UserDto;
import com.example.webapp.domain.User;
import com.example.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserAdministrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User show(@RequestParam Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user")
    public Iterable<User> showAll() {
        return userService.getUsers();
    }

    @PostMapping("/registration")
    public User addUser(@RequestBody UserDto newUser) {
        return userService.createUser(newUser);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserDto updateUser) {
        return userService.updateUser(id, updateUser);
    }

    @DeleteMapping("/user/{id}")
    public User deleteUser(@RequestParam Long id) {
        return userService.deleteUser(id);
    }
}
