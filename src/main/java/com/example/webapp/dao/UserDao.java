package com.example.webapp.dao;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class UserDao {
    private String username;
    private String password;
    private String email;
    private boolean active;

    public UserDao(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        active = false;
    }
}
