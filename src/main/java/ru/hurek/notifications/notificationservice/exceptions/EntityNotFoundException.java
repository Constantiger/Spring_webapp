package ru.hurek.notifications.notificationservice.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Long id) {
        super("Entity not found with id " + id);
    }
}
