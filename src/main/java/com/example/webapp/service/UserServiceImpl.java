package com.example.webapp.service;

import com.example.webapp.domain.Product;
import com.example.webapp.domain.User;
import com.example.webapp.domain.UserRole;
import com.example.webapp.error.ProductNotFoundException;
import com.example.webapp.error.UserExistsException;
import com.example.webapp.error.UserNotFoundException;
import com.example.webapp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
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

    @Override
    public void updateUser(String id, Product product){

    }

    @Override
    public User deleteUser(Long id) {
        User user;
        if (id != null && userRepo.existsById(id)) {
            user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
            userRepo.deleteById(id);
            return user;
        } else {
            throw new ProductNotFoundException(id);
        }
    }

    @Override
    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }
}
