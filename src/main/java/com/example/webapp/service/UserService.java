package com.example.webapp.service;

import com.example.webapp.dto.UserDto;
import com.example.webapp.domain.User;

public interface UserService {
    User createUser(UserDto newUser);
    User updateUser(Long id, UserDto user);
    User deleteUser(Long id);
    Iterable<User> getUsers();
    User getUserById(Long id);
}
