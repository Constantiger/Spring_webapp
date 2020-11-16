package com.example.webapp.repos;

import com.example.webapp.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    Iterable<Product> findByProductType(String productType);
    List<Product> findByProductType(String productType, Pageable page);
    Page<Product> findAll(Specification<Product> specification, Pageable page);
    List<Product> findByPriceBetweenAndAmountGreaterThanEqual(Long minPrice, Long maxPrice, Long amount, Pageable page);
    List<Product> findByProductTypeAndPriceBetweenAndAmountGreaterThanEqual(String productType, Long minPrice, Long maxPrice, Long amount, Pageable page);
}
