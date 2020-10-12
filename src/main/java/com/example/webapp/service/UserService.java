package com.example.webapp.service;

import com.example.webapp.error.UserExistsException;
import com.example.webapp.model.User;
import com.example.webapp.model.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username);

    public User saveUser(UserDto userDto);

    public User saveAdmin(UserDto userDto);

    public User deleteUser(String username);

    public Iterable<User> getAllUsers();

    public User getUser(String username);
}
