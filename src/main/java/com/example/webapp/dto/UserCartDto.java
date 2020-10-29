package com.example.webapp.dto;

import com.example.webapp.domain.UserCart;
import lombok.Value;

@Value
public class UserCartDto {
    String username;
    String password;

    public UserCartDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static UserCart getNewUserCart(UserCartDto userCartDto) {
        return new UserCart(userCartDto);
    }
}
