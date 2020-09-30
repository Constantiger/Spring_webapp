package com.example.webapp.controller;

import com.example.webapp.domain.Product;
import com.example.webapp.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProductAdministrationController {
    @Autowired
    private ProductRepo productRepo;

    @PostMapping("/add")
    public void add(@RequestParam (value = "text") String text, @RequestParam (value = "prodtype") String prodtype, @RequestParam (value = "price") long price) {
        Product product = new Product(text, prodtype, price);
        productRepo.save(product);
    }

    @PostMapping("/delete")
    public void dell(@RequestParam(value = "dell") String dell) {
        if (dell != null && !dell.isEmpty()
                && productRepo.existsById(Long.valueOf(dell))) {
            productRepo.deleteById(Long.valueOf(dell));
        }
    }
}
