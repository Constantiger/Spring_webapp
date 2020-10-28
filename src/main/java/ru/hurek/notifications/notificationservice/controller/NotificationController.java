package ru.hurek.notifications.notificationservice.controller;


import ru.hurek.notifications.notificationservice.model.NotificationDto;

import java.util.List;

public interface NotificationController {
    NotificationDto get(long id);
    List<NotificationDto> getAll();
    NotificationDto create(NotificationDto notificationDto);
    NotificationDto update(NotificationDto notificationDto);
    void delete(long id);
}
