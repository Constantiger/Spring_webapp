package com.example.webapp.controller;

import com.example.webapp.model.Product;
import com.example.webapp.model.User;
import com.example.webapp.service.ProductService;
import com.example.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetController {
    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @GetMapping("/Product/{type}")
    public Iterable<Product> getProductByType(@RequestParam String type) {
        return productService.getProductsByProdtype(type);
    }

    @GetMapping("/Product")
    public Iterable<Product> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/Users")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
