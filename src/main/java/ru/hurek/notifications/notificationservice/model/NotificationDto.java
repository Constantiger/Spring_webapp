package ru.hurek.notifications.notificationservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Value
@ApiModel(value = "Notification data transfer object", description = "Transfer notification data to service")
public class NotificationDto {
    @ApiModelProperty(value = "Subscription ID", required = true)
    @PositiveOrZero
    Long id;

    @ApiModelProperty(value = "User ID", required = true)
    @PositiveOrZero
    Long userId;

    @ApiModelProperty(value = "Notification type", required = true)
    @NotNull
    NotificationTypes type;

    @NotBlank
    @ApiModelProperty(value = "Notification event", required = true)
    String event;
}
