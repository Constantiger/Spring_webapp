package ru.hurek.notifications.notificationservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends ResponseStatusException {
    public EntityNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, "Subscription with id " + id + " not found");
    }
}
