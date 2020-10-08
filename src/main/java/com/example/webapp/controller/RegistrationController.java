package com.example.webapp.controller;

import com.example.webapp.model.Role;
import com.example.webapp.model.User;
import com.example.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public String addUser(@RequestBody User user) {
        user.setRole(Role.USER);
        if (!userService.saveUser(user)){
            return "registration";
        }
        return "redirect:/";
    }
    @PostMapping("/registrationAdmin")
    public String addUserAdmin(@RequestBody User user) {
        user.setRole(Role.ADMIN);
        if (!userService.saveUser(user)){
            return "registrationAdmin";
        }
        return "redirect:/";
    }
//    @GetMapping("/registration")
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//
//        return "registration";
//    }
//    @PostMapping("/registrationRole")
//    public String addRole(@RequestParam(value = "roleName") String roleName,
//                          @RequestParam(value = "id") Long id) {
//        Role role = new Role(id, roleName);
//        if (!userService.saveRole(role)){
//            return "registrationRole";
//        }
//        return "redirect:/";
//    }
}
