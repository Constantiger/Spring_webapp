package com.example.webapp.service;

import com.example.webapp.domain.UserCart;
import com.example.webapp.dto.UserCartDto;

import java.util.List;

public interface UserCartService {
    UserCart createUser(UserCartDto newUser);
    UserCart updateUser(long id, UserCartDto user);
    UserCart deleteUser(long id);
    Iterable<UserCart> getUsers();
    UserCart getUserById(long id);
    UserCart addToCart(long id, long productId);
    UserCart addProductsToCart(long id, List<Long> productIds);
    UserCart deleteFromCart(long id, long productId);
    UserCart deleteProductsFromCart(long id, List<Long> productIds);
    UserCart removeAllProductsFromCart(long id);
}
