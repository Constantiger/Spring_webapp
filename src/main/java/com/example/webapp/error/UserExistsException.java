package com.example.webapp.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserExistsException extends ResponseStatusException {
    public UserExistsException(String username) { super(HttpStatus.BAD_REQUEST, "User already exists. username: " + username); }
}