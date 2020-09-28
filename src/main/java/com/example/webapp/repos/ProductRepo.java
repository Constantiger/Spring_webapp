package com.example.webapp.repos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.webapp.domain.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
    List<Product> findByProdtype(String prodtype);
}
