package com.example.webapp.service;

import com.example.webapp.domain.Product;
import com.example.webapp.domain.User;
import com.example.webapp.domain.UserRole;
import com.example.webapp.error.UserExistsException;
import com.example.webapp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User createUser(String username, String password, String email) {
        User userFromDb = userRepo.findByUsername(username);
        if (userFromDb != null) {
            throw new UserExistsException(username);
        }
        User user = new User(username, password, email);
        user.setActive(true);
        user.setRoles(Collections.singleton(UserRole.USER));
        userRepo.save(user);
        return user;
    }
    public void updateUser(String id, Product product){

    }
    public void deleteUser(Long id) {

    }

    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }
}
