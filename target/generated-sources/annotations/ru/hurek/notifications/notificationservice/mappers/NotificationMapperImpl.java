package ru.hurek.notifications.notificationservice.mappers;

import javax.annotation.Generated;
import ru.hurek.notifications.notificationservice.model.Notification;
import ru.hurek.notifications.notificationservice.model.NotificationDto;
import ru.hurek.notifications.notificationservice.model.NotificationDtoIdLess;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-11T17:36:51+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9 (Amazon.com Inc.)"
)
public class NotificationMapperImpl implements NotificationMapper {

    @Override
    public NotificationDto toNotificationDto(Notification notification) {
        if ( notification == null ) {
            return null;
        }

        NotificationDto notificationDto = new NotificationDto();

        notificationDto.setId( notification.getId() );
        notificationDto.setUserId( notification.getUserId() );
        notificationDto.setType( notification.getType() );
        notificationDto.setEvent( notification.getEvent() );

        return notificationDto;
    }

    @Override
    public Notification toNotification(NotificationDto notificationDto) {
        if ( notificationDto == null ) {
            return null;
        }

        Notification notification = new Notification();

        notification.setId( notificationDto.getId() );
        notification.setUserId( notificationDto.getUserId() );
        notification.setType( notificationDto.getType() );
        notification.setEvent( notificationDto.getEvent() );

        return notification;
    }

    @Override
    public Notification toNewNotification(NotificationDtoIdLess notificationDtoIdLess) {
        if ( notificationDtoIdLess == null ) {
            return null;
        }

        Notification notification = new Notification();

        notification.setUserId( notificationDtoIdLess.getUserId() );
        notification.setType( notificationDtoIdLess.getType() );
        notification.setEvent( notificationDtoIdLess.getEvent() );

        return notification;
    }
}
