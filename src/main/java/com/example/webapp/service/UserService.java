package com.example.webapp.service;

import com.example.webapp.dto.UserDto;
import com.example.webapp.domain.User;

public interface UserService {
    User createUser(UserDto newUser);
    User updateUser(long id, UserDto user);
    User deleteUser(long id);
    Iterable<User> getUsers();
    User getUserById(long id);
}
