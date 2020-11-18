package ru.hurek.notifications.notificationservice.specifications;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.hurek.notifications.notificationservice.model.NotificationTypes;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel(value = "Filter parameters", description = "Return list of all notification subscriptions fit the criteria")
public class NotifFilter {
    @ApiModelProperty(value = "Filter by user ID")
    @PositiveOrZero
    private Long userId;

    @ApiModelProperty(value = "Filter by notification type")
    @NotNull
    private NotificationTypes type;

    @ApiModelProperty(value = "Filter by notification event")
    @NotBlank
    private String event;

    public NotifFilter(Long userId, NotificationTypes type, String event) {
        this.userId = userId;
        this.type = type;
        this.event = event;
    }
}
