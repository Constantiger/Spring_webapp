package ru.hurek.notifications.notificationservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.hurek.notifications.notificationservice.model.Notification;
import ru.hurek.notifications.notificationservice.model.NotificationDto;

@Component
public class NotificationToNotificationDtoConverter implements Converter <Notification, NotificationDto> {
    @Override
    public NotificationDto convert(Notification notification) {
        return new NotificationDto().setId(notification.getId())
                .setUserId(notification.getUserId())
                .setType(notification.getType())
                .setEvent(notification.getEvent());
    }
}
