package ru.hurek.notifications.notificationservice.mappers;

import java.util.ArrayList;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import ru.hurek.notifications.notificationservice.model.Notification;
import ru.hurek.notifications.notificationservice.model.NotificationDto;
import ru.hurek.notifications.notificationservice.model.NotificationDtoIdLess;
import ru.hurek.notifications.notificationservice.model.NotificationTypes;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-18T14:34:19+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9 (Amazon.com Inc.)"
)
@Component
public class NotificationMapperImpl implements NotificationMapper {

    @Override
    public NotificationDto toNotificationDto(Notification notification) {
        if ( notification == null ) {
            return null;
        }

        Long id = null;
        Long userId = null;
        NotificationTypes type = null;
        String event = null;

        id = notification.getId();
        userId = notification.getUserId();
        type = notification.getType();
        event = notification.getEvent();

        NotificationDto notificationDto = new NotificationDto( id, userId, type, event );

        return notificationDto;
    }

    @Override
    public Notification toNotification(NotificationDto notificationDto) {
        if ( notificationDto == null ) {
            return null;
        }

        Long id = null;
        Long userId = null;
        NotificationTypes type = null;
        String event = null;

        id = notificationDto.getId();
        userId = notificationDto.getUserId();
        type = notificationDto.getType();
        event = notificationDto.getEvent();

        Notification notification = new Notification( id, userId, type, event );

        return notification;
    }

    @Override
    public Notification toNewNotification(NotificationDtoIdLess notificationDtoIdLess) {
        if ( notificationDtoIdLess == null ) {
            return null;
        }

        Long userId = null;
        NotificationTypes type = null;
        String event = null;

        userId = notificationDtoIdLess.getUserId();
        type = notificationDtoIdLess.getType();
        event = notificationDtoIdLess.getEvent();

        Long id = null;

        Notification notification = new Notification( id, userId, type, event );

        return notification;
    }

    @Override
    public Iterable<NotificationDto> listOfNotificationDto(Iterable<Notification> notifications) {
        if ( notifications == null ) {
            return null;
        }

        ArrayList<NotificationDto> iterable = new ArrayList<NotificationDto>();
        for ( Notification notification : notifications ) {
            iterable.add( toNotificationDto( notification ) );
        }

        return iterable;
    }
}
