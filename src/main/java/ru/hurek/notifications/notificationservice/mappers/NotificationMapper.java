package ru.hurek.notifications.notificationservice.mappers;

import org.mapstruct.Mapper;
import ru.hurek.notifications.notificationservice.model.Notification;
import ru.hurek.notifications.notificationservice.model.NotificationDto;
import ru.hurek.notifications.notificationservice.model.NotificationDtoIdLess;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    NotificationDto toNotificationDto(Notification notification);

    Notification toNotification(NotificationDto notificationDto);

    Notification toNewNotification(NotificationDtoIdLess notificationDtoIdLess);

    Iterable<NotificationDto> listOfNotificationDto(Iterable<Notification> notifications);
}