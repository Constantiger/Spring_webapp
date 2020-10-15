package com.example.webapp.repos;

import com.example.webapp.domain.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepo extends CrudRepository<Cart, Long> {
    Iterable<Cart> findAll();
}
