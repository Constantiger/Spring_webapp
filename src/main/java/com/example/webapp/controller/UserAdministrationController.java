package com.example.webapp.controller;

import com.example.webapp.domain.User;
import com.example.webapp.dto.UserDto;
import com.example.webapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserAdministrationController {
    private final UserService userService;

    @GetMapping("/{id}")
    public User show(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping()
    public Iterable<User> showAll() {
        return userService.getUsers();
    }

    @PostMapping()
    public User addUser(@RequestBody UserDto newUser) {
        return userService.createUser(newUser);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserDto updateUser) {
        return userService.updateUser(id, updateUser);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
