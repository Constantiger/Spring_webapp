package com.example.webapp.controller;

import com.example.webapp.dao.ProductDao;
import com.example.webapp.domain.Product;
import com.example.webapp.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductAdministrationController {
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping("/product/{id}")
    public Product showById(@PathVariable Long id) {
        return productServiceImpl.getProductById(id);
    }

    @PostMapping("/product")
    public Product add(@RequestBody ProductDao newProduct) {
        return productServiceImpl.createProduct(newProduct);
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductDao updateProduct) {
        return productServiceImpl.updateProduct(id, updateProduct);
    }

    @DeleteMapping("/product/{id}")
    public Product dell(@RequestParam Long id) {
        return productServiceImpl.deleteProduct(id);
    }
}
