package com.example.webapp.dto;

import com.example.webapp.domain.UserCart;
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

    public static UserCart getNewUserCart(UserCartDto userCartDto) {
        return new UserCart(userCartDto);
    }
}
