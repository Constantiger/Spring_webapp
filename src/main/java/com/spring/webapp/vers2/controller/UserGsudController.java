package com.spring.webapp.vers2.controller;

import com.spring.webapp.vers2.model.User;
import com.spring.webapp.vers2.model.UserDto;
import com.spring.webapp.vers2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserGsudController {

    UserServiceImpl userServiceImpl;

    @PostMapping("/user")
    public User saveUser(@RequestBody UserDto userDto) {
        System.out.println(userDto.getUsername());
        System.out.println(userDto.getPassword());
        return userServiceImpl.saveUser(userDto);
    }

    @PostMapping("/admin")
    public User saveAdmin(@RequestBody UserDto userDto) {
        return userServiceImpl.saveAdmin(userDto);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody UserDto userDto) {
        return userServiceImpl.updateUser(userDto);
    }

    @DeleteMapping("/user/{username}")
    public User deleteUser(@PathVariable String username) {
        return userServiceImpl.deleteUser(username);
    }

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        return userServiceImpl.getUser(username);
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }
}
