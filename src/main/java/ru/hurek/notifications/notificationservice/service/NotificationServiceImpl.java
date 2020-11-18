package ru.hurek.notifications.notificationservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hurek.notifications.notificationservice.exceptions.EntityNotFoundException;
import ru.hurek.notifications.notificationservice.mappers.NotificationMapper;
import ru.hurek.notifications.notificationservice.specifications.NotifFilter;
import ru.hurek.notifications.notificationservice.model.Notification;
import ru.hurek.notifications.notificationservice.model.NotificationDto;
import ru.hurek.notifications.notificationservice.model.NotificationDtoIdLess;
import ru.hurek.notifications.notificationservice.repository.NotificationRepository;
import static ru.hurek.notifications.notificationservice.specifications.NotificationSpecs.specificationByFilter;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    @Override
    public NotificationDto get(long id) {
        Notification notification = notificationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        return notificationMapper.toNotificationDto(notification);
    }

    @Override
    public NotificationDto create(NotificationDtoIdLess notificationDtoIdLess) {
        Notification notification = notificationRepository.save(notificationMapper.toNewNotification(notificationDtoIdLess));
        return notificationMapper.toNotificationDto(notification);
    }

    @Override
    public NotificationDto update(NotificationDto notificationDto) {
        Notification notification = notificationRepository.save(notificationMapper.toNotification(notificationDto));
        return notificationMapper.toNotificationDto(notification);
    }

    @Override
    public NotificationDto delete(long id) {
        Notification notification = notificationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        notificationRepository.deleteById(id);
        return notificationMapper.toNotificationDto(notification);
    }

    @Override
    public Iterable<NotificationDto> getNotifications(NotifFilter filter) {
        return notificationMapper.listOfNotificationDto(notificationRepository.findAll(specificationByFilter(filter)));
    }
}
