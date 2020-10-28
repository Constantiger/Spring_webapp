package ru.hurek.notifications.notificationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hurek.notifications.notificationservice.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
