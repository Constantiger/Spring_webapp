package ru.hurek.notifications.notificationservice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hurek.notifications.notificationservice.model.NotificationDtoIdLess;
import ru.hurek.notifications.notificationservice.service.NotificationService;
import ru.hurek.notifications.notificationservice.model.NotificationDto;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Find a subscription by id", notes = "required long integer ID",
            response = NotificationDto.class)
    public NotificationDto get(@PathVariable long id) {
        return notificationService.get(id);
    }

    @GetMapping
    @ApiOperation(value = "Get all subscriptions", response = NotificationDto.class, responseContainer = "List")
    public List<NotificationDto> getAllSubscriptions() { return notificationService.getAll(); }

    @PostMapping
    @ApiOperation(value = "Subscribe to notification", notes = "Required NotificationDtoIdLess with set userId, type and event", response = NotificationDto.class)
    public NotificationDto subscribe(@ApiParam(value = "NotificationDtoIdLess", required = true) @RequestBody NotificationDtoIdLess notificationDtoIdLess) {
        return notificationService.create(notificationDtoIdLess);
    }

    @PutMapping
    @ApiOperation(value = "Update subscription", notes = "Required NotificationDto with set id, userId, type and event", response = NotificationDto.class)
    public NotificationDto updateSubscription(@ApiParam(value = "NotificationDto", required = true) @RequestBody NotificationDto notificationDto) {
        return notificationService.update(notificationDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete subscription by id", notes = "Required long integer ID", response = NotificationDto.class)
    public NotificationDto deleteSubscription(@PathVariable long id) {
        return notificationService.delete(id);
    }
}
