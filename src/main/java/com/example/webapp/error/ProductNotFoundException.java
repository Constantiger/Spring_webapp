package com.example.webapp.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends ResponseStatusException {
    public ProductNotFoundException(long id) {
        super(HttpStatus.NOT_FOUND, "Could not find product " + id);
    }
}
