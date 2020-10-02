package com.example.webapp.controller;

import com.example.webapp.domain.Product;
import com.example.webapp.error.ProductNotFoundException;
import com.example.webapp.repos.ProductRepo;
import com.example.webapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductAdministrationController {
    @Autowired
    private ProductService productService;

    @GetMapping("/show/{id}")
    public Product showById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    public void add(@RequestParam (value = "text") String text, @RequestParam (value = "prodtype") String prodtype,
                    @RequestParam (value = "price") long price) {
        productService.createProduct(text, prodtype, price);
    }

    @PostMapping("/delete")
    public void dell(@RequestParam(value = "dell") Long dellId) {
        productService.deleteProduct(dellId);
    }
}
