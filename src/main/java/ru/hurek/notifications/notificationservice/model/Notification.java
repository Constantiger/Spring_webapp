package ru.hurek.notifications.notificationservice.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "subscription", columnNames = {"user_id", "type", "event"}))
public class Notification {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @PositiveOrZero
    @Column(name = "id")
    private Long id;

    @PositiveOrZero
    @Column(name = "user_id")
    private Long userId;

    @NotNull
    @Column(name = "type")
    private NotificationTypes type;

    @NotBlank
    @Column(name = "event")
    private String event;
}
