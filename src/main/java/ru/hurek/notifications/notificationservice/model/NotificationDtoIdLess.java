package ru.hurek.notifications.notificationservice.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDtoIdLess {
    @NotNull
    private long userId;

    @NotNull
    private NotificationTypes type;

    @NotNull
    private String event;

}
