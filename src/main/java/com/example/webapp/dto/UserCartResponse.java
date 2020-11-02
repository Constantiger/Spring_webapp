package com.example.webapp.dto;

import com.example.webapp.domain.Product;
import com.example.webapp.domain.UserCart;
import lombok.Value;
import java.util.List;

@Value
public class UserCartResponse {
    Long id;
    String username;
    List<Product> cart;

    public UserCartResponse(UserCart userCart) {
        this.id = userCart.getId();
        this.username = userCart.getUsername();
        this.cart = userCart.getCart();
    }
}
