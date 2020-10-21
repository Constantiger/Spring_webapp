package com.example.webapp.dto;

import lombok.*;

@Value
public class UserDto {
    String username;
    String password;
    String email;
    boolean active;

    public UserDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        active = false;
    }
}
