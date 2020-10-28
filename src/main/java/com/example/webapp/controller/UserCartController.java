package com.example.webapp.controller;

import com.example.webapp.domain.UserCart;
import com.example.webapp.dto.UserCartDto;
import com.example.webapp.service.UserCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserCartController {
    private final UserCartService userCartService;

    @GetMapping("/userCart/{id}")
    public UserCart show(@PathVariable long id) {
        return userCartService.getUserById(id);
    }

    @GetMapping("/userCart")
    public Iterable<UserCart> showAll() {
        return userCartService.getUsers();
    }

    @PostMapping("/userCart")
    public UserCart addUser(@RequestBody UserCartDto newUser) {
        return userCartService.createUser(newUser);
    }

    @PutMapping("/userCart/{id}")
    public UserCart updateUser(@PathVariable long id, @RequestBody UserCartDto updateUser) {
        return userCartService.updateUser(id, updateUser);
    }

    @DeleteMapping("/userCart/{id}")
    public UserCart deleteUser(@PathVariable long id) {
        return userCartService.deleteUser(id);
    }

    @PutMapping("/userCart/{id}/product_{productId}")
    public UserCart addToCart(@PathVariable long id, @PathVariable long productId) {
        return userCartService.addToCart(id, productId);
    }

    @DeleteMapping("/userCart/{id}/product_{productId}")
    public UserCart deleteFromCart(@PathVariable long id, @PathVariable long productId) {
        return userCartService.deleteFromCart(id, productId);
    }
}
