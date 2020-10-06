package com.example.webapp.controller;

import com.example.webapp.domain.Product;
import com.example.webapp.repos.ProductRepo;
import com.example.webapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShowController {
    @Autowired
    private ProductService productService;

    @GetMapping("/Product/{type}")
    public Iterable<Product> show(@RequestParam String type) {
        return productService.getProductsByProdtype(type);
    }

    @GetMapping("/Product")
    public Iterable<Product> showAll() {
        return productService.getProducts();
    }
}
