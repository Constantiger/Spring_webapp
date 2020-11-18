package ru.hurek.notifications.notificationservice.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hurek.notifications.notificationservice.specifications.NotifFilter;
import ru.hurek.notifications.notificationservice.model.NotificationDto;
import ru.hurek.notifications.notificationservice.model.NotificationDtoIdLess;
import ru.hurek.notifications.notificationservice.service.NotificationService;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping("/{id}")
    public NotificationDto getSubscriptionById(@PathVariable long id) {
        return notificationService.get(id);
    }

    @GetMapping
    @ApiOperation(value = "Get filtered subscriptions", notes = "Filter all subscriptions by user, type and event")
    public Iterable<NotificationDto> getSubscriptions(NotifFilter filter) { return notificationService.getNotifications(filter); }

    @PostMapping
    public NotificationDto subscribe(@RequestBody NotificationDtoIdLess notificationDtoIdLess) {
        return notificationService.create(notificationDtoIdLess);
    }

    @PutMapping
    public NotificationDto updateSubscription(@RequestBody NotificationDto notificationDto) {
        return notificationService.update(notificationDto);
    }

    @DeleteMapping("/{id}")
    public NotificationDto deleteSubscriptionById(@PathVariable long id) {
        return notificationService.delete(id);
    }
}
