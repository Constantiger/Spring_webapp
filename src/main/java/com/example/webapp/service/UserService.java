package com.example.webapp.service;

import com.example.webapp.error.UserExistsException;
import com.example.webapp.model.Product;
import com.example.webapp.model.User;
import com.example.webapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + " not found");
        }
        return (UserDetails) user;
    }

    public boolean saveUser(User user) throws UserExistsException {
        User userFromBd = userRepository.findByUsername(user.getUsername());

        if (userFromBd != null) {
            throw new UserExistsException(user.getUsername());
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    @PreAuthorize("hasAuthority('user:write')")
    public boolean deleteUser(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        userRepository.deleteById(user.getId());
        return true;
    }

    @PreAuthorize("hasAuthority('user:write')")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
