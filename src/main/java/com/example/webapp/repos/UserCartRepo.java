package com.example.webapp.repos;

import com.example.webapp.domain.UserCart;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserCartRepo extends CrudRepository<UserCart, Long> {
    Optional<UserCart> findByUsername(String username);
    Iterable<UserCart> findAll();
}
