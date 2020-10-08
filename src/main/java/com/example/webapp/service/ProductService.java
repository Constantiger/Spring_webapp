package com.example.webapp.service;

import com.example.webapp.dao.ProductDao;
import com.example.webapp.dao.ProductFilter;
import com.example.webapp.domain.Product;

public interface ProductService {
    Product createProduct(ProductDao newProduct);
    Product updateProduct(Long id, ProductDao updateProduct);
    Product deleteProduct(Long id);
    Iterable<Product> getProducts();
    Product getProductById(Long id);
    Iterable<Product> getProductsByFilter(ProductFilter filter);
}
