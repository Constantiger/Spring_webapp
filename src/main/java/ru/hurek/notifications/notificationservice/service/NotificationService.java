package ru.hurek.notifications.notificationservice.service;

import ru.hurek.notifications.notificationservice.model.NotificationDto;
import ru.hurek.notifications.notificationservice.model.NotificationDtoIdLess;

import java.util.List;

public interface NotificationService {
    NotificationDto get(long id);
    List<NotificationDto> getAll();
    NotificationDto create(NotificationDtoIdLess notificationDtoIdLess);
    NotificationDto update(NotificationDto notificationDto);
    NotificationDto delete(long id);
}
