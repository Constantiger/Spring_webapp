package com.example.webapp.controller;

import com.example.webapp.dao.ProductDao;
import com.example.webapp.domain.Product;
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
    public Product add(@RequestBody ProductDao newProduct) {
        return productService.createProduct(newProduct);
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductDao updateProduct) {
        return productService.updateProduct(id, updateProduct);
    }

    @DeleteMapping("/product/{id}")
    public Product dell(@RequestParam Long id) {
        return productService.deleteProduct(id);
    }
}
