package com.example.webapp.domain;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class UserDto {
    private String username;
    private String password;
    private String email;
    private boolean active;

    public UserDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        active = false;
    }
}
