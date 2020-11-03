package com.example.webapp.service;

import com.example.webapp.dto.ProductDto;
import com.example.webapp.domain.ProductFilter;
import com.example.webapp.domain.Product;
import com.example.webapp.dto.ProductResponse;


public interface ProductService {
    ProductResponse createProduct(ProductDto newProduct);
    ProductResponse updateProduct(long id, ProductDto updateProduct);
    ProductResponse deleteProduct(long id);
    Iterable<ProductResponse> getProducts();
    ProductResponse getProductResponseById(long id);
    Product getProductById(long id);
    Iterable<ProductResponse> getProductById(Iterable<Long> ids);
    Iterable<ProductResponse> getProducts(ProductFilter filter);
}
