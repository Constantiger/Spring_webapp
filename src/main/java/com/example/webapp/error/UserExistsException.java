package com.example.webapp.error;

public class UserExistsException extends RuntimeException {
    public UserExistsException(String username) {
        super("User already exists. username: " + username);
    }
}