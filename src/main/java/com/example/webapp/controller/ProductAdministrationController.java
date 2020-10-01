package com.example.webapp.controller;

import com.example.webapp.domain.Product;
import com.example.webapp.error.ProductNotFoundException;
import com.example.webapp.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductAdministrationController {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/show/{id}")
    public Product showById(@PathVariable Long id) {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PostMapping("/add")
    public void add(@RequestParam (value = "text") String text, @RequestParam (value = "prodtype") String prodtype,
                    @RequestParam (value = "price") long price) {
        Product product = new Product(text, prodtype, price);
        productRepo.save(product);
    }

    @PostMapping("/delete")
    public void dell(@RequestParam(value = "dell") Long dellId) {
        if (dellId != null && productRepo.existsById(dellId)) {
            productRepo.deleteById(dellId);
        } else {
            throw new ProductNotFoundException(dellId);
        }

    }
}
