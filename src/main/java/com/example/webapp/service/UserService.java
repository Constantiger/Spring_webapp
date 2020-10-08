package com.example.webapp.service;

import com.example.webapp.domain.Product;
import com.example.webapp.domain.User;
import java.util.Optional;

public interface UserService {
    User createUser(String username, String password, String email);
    void updateUser(String id, Product product);
    User deleteUser(Long id);
    Iterable<User> getUsers();
    Optional<User> getUserById(Long id);
}
