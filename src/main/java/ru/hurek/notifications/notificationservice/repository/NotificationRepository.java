package ru.hurek.notifications.notificationservice.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.hurek.notifications.notificationservice.model.Notification;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long>, JpaSpecificationExecutor<Notification> {
}
