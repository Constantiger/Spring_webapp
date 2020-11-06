package ru.hurek.notifications.notificationservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.hurek.notifications.notificationservice.model.Notification;
import ru.hurek.notifications.notificationservice.model.NotificationDto;

@Mapper
public interface NotificationMapper {
    NotificationMapper INSTANCE = Mappers.getMapper( NotificationMapper.class );

    NotificationDto toNotificationDto(Notification notification);

    Notification toNotification(NotificationDto notificationDto);
}