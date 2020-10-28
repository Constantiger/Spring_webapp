package ru.hurek.notifications.notificationservice.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Accessors(chain = true)
public class Notification {
    @Id
    private long id;
    private long userId;
    private NotificationTypes type;
    private String event;
}
