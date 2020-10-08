//package com.example.webapp.controller;
//
//import com.example.webapp.domain.User;
//import com.example.webapp.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Optional;
//
//@RestController
//public class UserAdministrationController {
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/User/{id}")
//    public Optional<User> show(@RequestParam Long id) {
//        return userService.getUserById(id);
//    }
//
//    @GetMapping("/User")
//    public Iterable<User> showAll() {
//        return userService.getUsers();
//    }
//
//    @PostMapping("/registration1")
//    public User addUser(@RequestParam(value = "username") String username,
//                         @RequestParam (value = "password") String password,
//                         @RequestParam (value = "email") String email) {
//        return userService.createUser(username, password, email);
//    }
//}
