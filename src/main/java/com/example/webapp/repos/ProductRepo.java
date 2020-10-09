package com.example.webapp.repos;

import com.example.webapp.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Long> {
    Iterable<Product> findByProductType(String productType);
}
