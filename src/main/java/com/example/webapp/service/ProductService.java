package com.example.webapp.service;

import com.example.webapp.domain.Product;

public interface ProductService {
    void createProduct(Product product);
    void updateProduct(String id, Product product);
    void deleteProduct(String id);
    Iterable<Product> getProducts();
}
