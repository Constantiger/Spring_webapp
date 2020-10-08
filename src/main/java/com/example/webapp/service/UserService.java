package com.example.webapp.service;

import com.example.webapp.dao.UserDao;
import com.example.webapp.domain.Product;
import com.example.webapp.domain.User;
import java.util.Optional;

public interface UserService {
    User createUser(UserDao newUser);
    User updateUser(Long id, UserDao user);
    User deleteUser(Long id);
    Iterable<User> getUsers();
    User getUserById(Long id);
}
