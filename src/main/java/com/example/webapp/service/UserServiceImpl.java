package com.example.webapp.service;

import com.example.webapp.dao.UserDao;
import com.example.webapp.domain.User;
import com.example.webapp.domain.UserRole;
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
    public User createUser(UserDao newUser) {
        User userFromDb = userRepo.findByUsername(newUser.getUsername());
        if (userFromDb != null) {
            throw new UserExistsException(newUser.getUsername());
        }
        User user = new User(newUser.getUsername(), newUser.getPassword(), newUser.getEmail());
        user.setActive(true);
        user.setRoles(Collections.singleton(UserRole.USER));
        userRepo.save(user);
        return user;
    }

    @Override
    public User updateUser(Long id, UserDao updateUser){
        User user;
        if (id != null && userRepo.existsById(id)) {
            user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        } else {
            throw new UserNotFoundException(id);
        }
        user.setUsername(updateUser.getUsername());
        user.setPassword(updateUser.getPassword());
        user.setEmail(updateUser.getEmail());
        userRepo.save(user);
        return user;
    }

    @Override
    public User deleteUser(Long id) {
        User user;
        if (id != null && userRepo.existsById(id)) {
            user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
            userRepo.deleteById(id);
            return user;
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}
