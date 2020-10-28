package ru.hurek.notifications.notificationservice.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NotificationDto {
    private long id;
    private long userId;
    private NotificationTypes type;
    private String event;
}
