package com.spring.webapp.vers2.service;

import com.spring.webapp.vers2.exception.UnknownEntityException;
import com.spring.webapp.vers2.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Product getProduct(long productId) throws UnknownEntityException;
    Optional<Product> findById(long productId);
    void create(Product product);
    void update(Long productId, Product product) throws UnknownEntityException;
    void delete(Long productId);
}
