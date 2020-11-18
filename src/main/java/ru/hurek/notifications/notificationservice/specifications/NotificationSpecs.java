package ru.hurek.notifications.notificationservice.specifications;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import ru.hurek.notifications.notificationservice.model.Notification;
import ru.hurek.notifications.notificationservice.model.NotificationTypes;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NotificationSpecs {

    public static Specification<Notification> notificationTypeIs(NotificationTypes type) {
        return (root, query, builder) -> type == null ? null : builder.equal(root.get(Notification_.type), type);
    }

    public static Specification<Notification> userIs(Long userId) {
        return (root, query, builder) -> userId == null ? null : builder.equal(root.get(Notification_.userId), userId);
    }

    public static Specification<Notification> eventIs(String event) {
        return (root, query, builder) -> event == null ? null : builder.equal(root.get(Notification_.event), event);
    }

    public static Specification<Notification> specificationByFilter(NotifFilter notifFilter) {
        return Specification.where(notificationTypeIs(notifFilter.getType())
                .and(userIs(notifFilter.getUserId()).and(eventIs(notifFilter.getEvent()))));
    }
}
