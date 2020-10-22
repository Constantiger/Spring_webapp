package com.example.webapp.repos;

import com.example.webapp.domain.UserCart;
import org.springframework.data.repository.CrudRepository;

public interface UserCartRepo extends CrudRepository<UserCart, Long> {
    UserCart findByUsername(String username);
    Iterable<UserCart> findAll();
}
