package com.busylessman.shop.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ProductService {
    ProductDto get(Long id);
    List<ProductDto> getAll();
    ProductDto create(ProductDto productDto);
    ProductDto update(ProductDto productDto);
    void delete(Long id);
}
