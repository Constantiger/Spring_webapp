package ru.hurek.notifications.notificationservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Value
@ApiModel(value = "New notification data transfer object", description = "Transfer new notification data to service")
public class NotificationDtoIdLess {
    @ApiModelProperty(value = "User ID", required = true)
    @PositiveOrZero
    Long userId;

    @ApiModelProperty(value = "Notification type", required = true)
    @NotNull
    NotificationTypes type;

    @ApiModelProperty(value = "Notification event", required = true)
    @NotBlank
    String event;
}
