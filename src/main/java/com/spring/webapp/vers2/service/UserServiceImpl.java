package com.spring.webapp.vers2.service;

import com.spring.webapp.vers2.model.Role;
import com.spring.webapp.vers2.model.User;
import com.spring.webapp.vers2.model.UserDto;
import com.spring.webapp.vers2.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        return (UserDetails) user;
    }

    public User saveUser(UserDto userDto) {
        System.out.println("ok");
        User userDb = userRepository.findUserByUsername(userDto.getUsername());
        if (userDb != null)
            return userDb;
        User user = new User(userDto.getUsername(), encoder.encode(userDto.getPassword()), Role.USER);
        userRepository.save(user);
        return user;
    }

    public User saveAdmin(UserDto userDto) {
        User userDb = userRepository.findUserByUsername(userDto.getUsername());
        if (userDb != null)
            return userDb;
        User user = new User(userDto.getUsername(), encoder.encode(userDto.getPassword()), Role.ADMIN);
        userRepository.save(user);
        return user;
    }

    public User updateUser(UserDto userDto) {
        User userDb = userRepository.findUserByUsername(userDto.getUsername());
        userDb.setUsername(userDto.getUsername());
        userDb.setPassword(userDto.getPassword());
        userRepository.save(userDb);
        return userDb;
    }

    @PreAuthorize("hasAuthority('user:write')")
    public User deleteUser(String username) {
        User user = userRepository.findUserByUsername(username);
        userRepository.deleteById(user.getId());
        return user;
    }

    @PreAuthorize("hasAuthority('user:write')")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String username) {
        return userRepository.findUserByUsername(username);
    }
}
