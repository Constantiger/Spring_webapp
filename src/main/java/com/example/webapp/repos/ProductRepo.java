package com.example.webapp.repos;

import com.example.webapp.domain.Product;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableJpaRepositories
public interface ProductRepo extends CrudRepository<Product, Long> {
    List<Product> findByProdtype(String prodtype);
}
