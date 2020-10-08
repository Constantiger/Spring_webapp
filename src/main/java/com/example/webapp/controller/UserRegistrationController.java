package com.example.webapp.controller;

import com.example.webapp.model.Product;
import com.example.webapp.model.Role;
import com.example.webapp.model.User;
import com.example.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public String postUser(@RequestBody User user) {
        user.setRole(Role.USER);
        if (!userService.saveUser(user)){
            return "registration";
        }
        return "redirect:/";
    }

    @PostMapping("/registrationAdmin")
    public String postUserAdmin(@RequestBody User user) {
        user.setRole(Role.ADMIN);
        if (!userService.saveUser(user)){
            return "registrationAdmin";
        }
        return "redirect:/";
    }

    @DeleteMapping("/delete/{username}")
    public String deleteUser(@RequestParam String username) {
        if (!userService.deleteUser(username))
            return "redirect:/delete_error";
        return "redirect:/";
    }
}
