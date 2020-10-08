package com.example.webapp.controller;

import com.example.webapp.dao.ProductFilter;
import com.example.webapp.domain.Product;
import com.example.webapp.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShowController {
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping("/filter")
    public Iterable<Product> show(ProductFilter filter) {
        return productServiceImpl.getProductsByFilter(filter);
    }

    @GetMapping("/products")
    public Iterable<Product> showAll() {
        return productServiceImpl.getProducts();
    }
}
