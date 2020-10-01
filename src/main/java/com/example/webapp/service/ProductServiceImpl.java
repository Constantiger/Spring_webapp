package com.example.webapp.service;

import com.example.webapp.domain.Product;
import com.example.webapp.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    public void createProduct(Product product) {

    }
    public void updateProduct(String id, Product product){

    }
    public void deleteProduct(String id) {

    }
    public Iterable<Product> getProducts() {
        return productRepo.findAll();
    }
}
