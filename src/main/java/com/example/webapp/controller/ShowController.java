package com.example.webapp.controller;


import com.example.webapp.domain.Product;
import com.example.webapp.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShowController {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/show")
    public Iterable<Product> show(@RequestParam(value = "filter") String filter) {
        Iterable<Product> products;
        if (filter != null && !filter.isEmpty()) {
            products = productRepo.findByProdtype(filter);
        } else {
            products = productRepo.findAll();
        }
        return products;
    }

    @GetMapping("/showAll")
    public Iterable<Product> showAll() {
        return (productRepo.findAll());
    }
}
