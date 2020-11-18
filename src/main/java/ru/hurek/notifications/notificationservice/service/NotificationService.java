package ru.hurek.notifications.notificationservice.service;

import ru.hurek.notifications.notificationservice.specifications.NotifFilter;
import ru.hurek.notifications.notificationservice.model.NotificationDto;
import ru.hurek.notifications.notificationservice.model.NotificationDtoIdLess;

public interface NotificationService {
    NotificationDto get(long id);
    NotificationDto create(NotificationDtoIdLess notificationDtoIdLess);
    NotificationDto update(NotificationDto notificationDto);
    NotificationDto delete(long id);
    Iterable<NotificationDto> getNotifications(NotifFilter filter);
}
