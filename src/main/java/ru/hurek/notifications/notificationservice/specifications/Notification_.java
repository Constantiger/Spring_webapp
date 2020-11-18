package ru.hurek.notifications.notificationservice.specifications;

import ru.hurek.notifications.notificationservice.model.Notification;
import ru.hurek.notifications.notificationservice.model.NotificationTypes;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Notification.class)
public class Notification_ {
    public static volatile SingularAttribute<Notification, Long> id;
    public static volatile SingularAttribute<Notification, Long> userId;
    public static volatile SingularAttribute<Notification, NotificationTypes> type;
    public static volatile SingularAttribute<Notification, String> event;
}
