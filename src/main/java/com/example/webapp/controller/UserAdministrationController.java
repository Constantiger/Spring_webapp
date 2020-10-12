package com.example.webapp.controller;

import com.example.webapp.model.User;
import com.example.webapp.model.UserDto;
import com.example.webapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserAdministrationController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/user")
    public User postUser(@RequestBody UserDto userDto) {
        return userServiceImpl.saveUser(userDto);
    }

    @PostMapping("/admin")
    public User postUserAdmin(@RequestBody UserDto userDto) {
        return userServiceImpl.saveAdmin(userDto);
    }

    @DeleteMapping("/user/{username}")
    public User deleteUser(@PathVariable String username) {
        return (userServiceImpl.deleteUser(username));
    }

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        return userServiceImpl.getUser(username);
    }

    @GetMapping("/user")
    public Iterable<User> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }
}
