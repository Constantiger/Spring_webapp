package com.example.webapp.service;

import com.example.webapp.dto.ProductDto;
import com.example.webapp.domain.ProductFilter;
import com.example.webapp.domain.Product;

public interface ProductService {
    Product createProduct(ProductDto newProduct);
    Product updateProduct(long id, ProductDto updateProduct);
    Product deleteProduct(long id);
    Iterable<Product> getProducts();
    Product getProductById(long id);
    Iterable<Product> getProductById(Iterable<Long> ids);
    Iterable<Product> getProducts(ProductFilter filter);
}
