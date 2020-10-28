package ru.hurek.notifications.notificationservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hurek.notifications.notificationservice.service.NotificationService;
import ru.hurek.notifications.notificationservice.model.NotificationDto;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationControllerImpl implements NotificationController {
    private final NotificationService notificationService;

    @GetMapping("/{id}")
    @Override
    public NotificationDto get(@PathVariable long id) {
        return notificationService.get(id);
    }

    @GetMapping
    @Override
    public List<NotificationDto> getAll() {
        return notificationService.getAll();
    }

    @PostMapping
    @Override
    public NotificationDto create(@RequestBody NotificationDto notificationDto) {
        return notificationService.create(notificationDto);
    }

    @PutMapping
    @Override
    public NotificationDto update(@RequestBody NotificationDto notificationDto) {
        return notificationService.update(notificationDto);
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable long id) {
        notificationService.delete(id);
    }
}
