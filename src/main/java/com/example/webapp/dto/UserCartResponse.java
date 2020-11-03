package com.example.webapp.dto;

import com.example.webapp.domain.UserCart;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class UserCartResponse {
    Long id;
    String username;
    Iterable<ProductResponse> cart;

    public UserCartResponse(UserCart userCart) {
        this.id = userCart.getId();
        this.username = userCart.getUsername();
        this.cart = ProductResponse.convert(userCart.getCart());
    }

    public static Iterable<UserCartResponse> convert(Iterable<UserCart> products) {
        List<UserCartResponse> responses = new ArrayList<>();
        products.forEach(userCart -> responses.add(new UserCartResponse(userCart)));
        return responses;
    }
}
