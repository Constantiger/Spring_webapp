package com.example.webapp.controller;

import com.example.webapp.domain.Product;
import com.example.webapp.domain.UserCart;
import com.example.webapp.dto.UserCartDto;
import com.example.webapp.service.UserCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserCartController {
    private final UserCartService userCartService;

    public UserCartController(@Autowired UserCartService userCartService) {
        this.userCartService = userCartService;
    }

    @GetMapping("/usercart/{id}")
    public UserCart show(@RequestParam Long id) {
        return userCartService.getUserById(id);
    }

    @GetMapping("/usercart")
    public Iterable<UserCart> showAll() {
        return userCartService.getUsers();
    }

    @PostMapping("/usercart")
    public UserCart addUser(@RequestBody UserCartDto newUser) {
        return userCartService.createUser(newUser);
    }

    @PutMapping("/usercart/{id}")
    public UserCart updateUser(@PathVariable Long id, @RequestBody UserCartDto updateUser) {
        return userCartService.updateUser(id, updateUser);
    }

    @DeleteMapping("/usercart/{id}")
    public UserCart deleteUser(@RequestParam Long id) {
        return userCartService.deleteUser(id);
    }

    @PutMapping("/usercart/{id}/product-{productid}")
    public UserCart addToCart(@PathVariable Long id, @PathVariable Long productid) {
        return userCartService.addToCart(id, productid);
    }

    @DeleteMapping("/usercart/{id}/product-{productid}")
    public UserCart deleteFromCart(@PathVariable Long id, @PathVariable Long productid) {
        return userCartService.deleteFromCart(id, productid);
    }

    @GetMapping("/usercart/{id}/cart")
    public Iterable<Product> productFromCart(@PathVariable Long id) {
        return userCartService.productFromCart(id);
    }
}
