package com.example.webapp.service;

import com.example.webapp.domain.ProductDto;
import com.example.webapp.domain.ProductFilter;
import com.example.webapp.domain.Product;

public interface ProductService {
    Product createProduct(ProductDto newProduct);
    Product updateProduct(Long id, ProductDto updateProduct);
    Product deleteProduct(Long id);
    Iterable<Product> getProducts();
    Product getProductById(Long id);
    Iterable<Product> getProductsByFilter(ProductFilter filter);
}
