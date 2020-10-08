package com.example.webapp.controller;

import com.example.webapp.model.Product;
import com.example.webapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductAdministrationController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public Product showById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/product")
    public Product add(@RequestParam (value = "text") String text, @RequestParam (value = "prodtype") String prodtype,
                    @RequestParam (value = "price") long price) {
        return productService.createProduct(text, prodtype, price);
    }

    @DeleteMapping("/delete/{id}")
    public Product dell(@RequestParam Long id) {
        return productService.deleteProduct(id);
    }
}
