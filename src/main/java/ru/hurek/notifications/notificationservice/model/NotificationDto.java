package ru.hurek.notifications.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDto {
    private long id;
    private long userId;
    private NotificationTypes type;
    private String event;
}
