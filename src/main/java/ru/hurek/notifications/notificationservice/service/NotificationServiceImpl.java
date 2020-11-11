package ru.hurek.notifications.notificationservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
//import ru.hurek.notifications.notificationservice.converter.NotificationDtoToNotificationConverter;
import ru.hurek.notifications.notificationservice.exceptions.EntityNotFoundException;
import ru.hurek.notifications.notificationservice.mappers.NotificationMapper;
import ru.hurek.notifications.notificationservice.model.NotificationDtoIdLess;
import ru.hurek.notifications.notificationservice.repository.NotificationRepository;
//import ru.hurek.notifications.notificationservice.converter.NotificationToNotificationDtoConverter;
import ru.hurek.notifications.notificationservice.model.Notification;
import ru.hurek.notifications.notificationservice.model.NotificationDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;


    @Override
    public NotificationDto get(long id) {
        Notification notification = notificationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        return NotificationMapper.INSTANCE.toNotificationDto(notification);
    }

    @Override
    public List<NotificationDto> getAll() {
        return notificationRepository.findAll().stream()
                .map(NotificationMapper.INSTANCE::toNotificationDto)
                .collect(Collectors.toList());
    }

    @Override
    public NotificationDto create(NotificationDtoIdLess notificationDtoIdLess) {
        Notification notification = notificationRepository.save(NotificationMapper.INSTANCE.toNewNotification(notificationDtoIdLess));
        return NotificationMapper.INSTANCE.toNotificationDto(notification);
    }

    @Override
    public NotificationDto update(NotificationDto notificationDto) {
        Notification notification = notificationRepository.save(NotificationMapper.INSTANCE.toNotification(notificationDto));
        return NotificationMapper.INSTANCE.toNotificationDto(notification);
    }

    @Override
    public NotificationDto delete(long id) {
        Notification notification = notificationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        notificationRepository.deleteById(id);
        return NotificationMapper.INSTANCE.toNotificationDto(notification);
    }
}
