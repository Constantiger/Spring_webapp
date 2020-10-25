package com.example.webapp.controller;

import com.example.webapp.domain.Product;
import com.example.webapp.domain.ProductFilter;
import com.example.webapp.dto.ProductDto;
import com.example.webapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProductAdministrationController {
    private final ProductService productService;

    @GetMapping("/product/{id}")
    public Product productById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/product")
    public Iterable<Product> product(ProductFilter filter) {
        return productService.getProducts(filter);
    }

    @GetMapping("/product/all")
    public Iterable<Product> allProduct() {
        return productService.getProducts();
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody ProductDto newProduct) {
        return productService.createProduct(newProduct);
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductDto updateProduct) {
        return productService.updateProduct(id, updateProduct);
    }

    @DeleteMapping("/product/{id}")
    public Product deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
