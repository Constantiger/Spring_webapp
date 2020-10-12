package com.example.webapp.controller;

import com.example.webapp.model.Product;
import com.example.webapp.model.User;
import com.example.webapp.service.ProductService;
import com.example.webapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetController {
    @Autowired
    private ProductService productService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/Product/{type}")
    public Iterable<Product> getProductByType(@PathVariable String type) {
        return productService.getProductsByProdtype(type);
    }

    @GetMapping("/Product")
    public Iterable<Product> getAllProducts() {
        return productService.getProducts();
    }

}
