package com.example.webapp.repos;

import com.example.webapp.domain.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long> {
    Iterable<Product> findByProductType(String productType);
    List<Product> findByProductType(String productType, Pageable page);
    List<Product> findAll(Pageable page);
    List<Product> findByPriceBetweenAndAmountGreaterThanEqual(Long minPrice, Long maxPrice, Long amount, Pageable page);
    List<Product> findByProductTypeAndPriceBetweenAndAmountGreaterThanEqual(String productType, Long minPrice, Long maxPrice, Long amount, Pageable page);
}
