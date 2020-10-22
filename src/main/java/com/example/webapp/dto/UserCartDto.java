package com.example.webapp.dto;

import lombok.Value;

@Value
public class UserCartDto {
    String username;

    public UserCartDto() {
        username = null;
    }

    public UserCartDto(String username) {
        this.username = username;
    }
}
