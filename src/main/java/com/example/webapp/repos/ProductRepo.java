package com.example.webapp.repos;

import com.example.webapp.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long> {
    Iterable<Product> findByProductType(String productType);
}
