package com.example.webapp.service;

import com.example.webapp.error.UserExistsException;
import com.example.webapp.model.Role;
import com.example.webapp.model.User;
import com.example.webapp.model.UserDto;
import com.example.webapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return (UserDetails) user;
    }

    public User saveUser(UserDto userDto){
        User userFromBd = userRepository.findByUsername(userDto.getUsername());
        if (userFromBd != null)
            return userFromBd;
        User user = new User(userDto.getUsername(), encoder.encode(userDto.getPassword()), Role.USER);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    public User saveAdmin(UserDto userDto){
        User userFromBd = userRepository.findByUsername(userDto.getUsername());
        if (userFromBd != null)
            return userFromBd;
        User user = new User(userDto.getUsername(), encoder.encode(userDto.getPassword()), Role.ADMIN);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }


    @PreAuthorize("hasAuthority('user:write')")
    public User deleteUser(String username){
        User user = userRepository.findByUsername(username);
        userRepository.deleteById(user.getId());
        return user;
    }

    @PreAuthorize("hasAuthority('user:write')")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
}
