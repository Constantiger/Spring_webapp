package com.spring.webapp.vers2.service;

import com.spring.webapp.vers2.model.User;
import com.spring.webapp.vers2.model.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    @Override
    UserDetails loadUserByUsername(String username);
    User saveUser(UserDto userDto);
    User saveAdmin(UserDto userDto);
    User updateUser(UserDto userDto);
    User deleteUser(String username);
    List<User> getAllUsers();
    User getUser(String username);
}
