package ru.hurek.notifications.notificationservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.hurek.notifications.notificationservice.model.Notification;
import ru.hurek.notifications.notificationservice.model.NotificationDto;

//@Component
//public class NotificationDtoToNotificationConverter implements Converter <NotificationDto, Notification> {
//    @Override
//    public Notification convert(NotificationDto notificationDto) {
//        return new Notification().setId(notificationDto.getId())
//                .setUserId(notificationDto.getUserId())
//                .setType(notificationDto.getType())
//                .setEvent(notificationDto.getEvent());
//    }
//}
