package ru.hurek.notifications.notificationservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hurek.notifications.notificationservice.converter.NotificationDtoToNotificationConverter;
import ru.hurek.notifications.notificationservice.repository.NotificationRepository;
import ru.hurek.notifications.notificationservice.converter.NotificationToNotificationDtoConverter;
import ru.hurek.notifications.notificationservice.model.Notification;
import ru.hurek.notifications.notificationservice.model.NotificationDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationDtoToNotificationConverter notificationDtoToNotificationConverter;
    private final NotificationToNotificationDtoConverter notificationToNotificationDtoConverter;

    @Override
    public NotificationDto get(long id) {
        Notification notification = notificationRepository.findById(id).orElseThrow(RuntimeException::new);
        return notificationToNotificationDtoConverter.convert(notification);
    }

    @Override
    public List<NotificationDto> getAll() {
        return notificationRepository.findAll().stream()
                .map(notificationToNotificationDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public NotificationDto create(NotificationDto notificationDto) {
        Notification notification = notificationRepository.save(notificationDtoToNotificationConverter.convert(notificationDto));
        return notificationToNotificationDtoConverter.convert(notification);
    }

    @Override
    public NotificationDto update(NotificationDto notificationDto) {
        Notification notification = notificationRepository.save(notificationDtoToNotificationConverter.convert(notificationDto));
        return notificationToNotificationDtoConverter.convert(notification);
    }

    @Override
    public void delete(long id) {
        notificationRepository.deleteById(id);
    }
}
