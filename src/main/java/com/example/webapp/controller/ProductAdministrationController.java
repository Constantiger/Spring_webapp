package com.example.webapp.controller;

import com.example.webapp.domain.ProductDto;
import com.example.webapp.domain.Product;
import com.example.webapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductAdministrationController {
    private final ProductService productService;

    ProductAdministrationController(@Autowired ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public Product showById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/product")
    public Product add(@RequestBody ProductDto newProduct) {
        return productService.createProduct(newProduct);
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductDto updateProduct) {
        return productService.updateProduct(id, updateProduct);
    }

    @DeleteMapping("/product/{id}")
    public Product dell(@RequestParam Long id) {
        return productService.deleteProduct(id);
    }
}
