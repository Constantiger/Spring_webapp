package com.example.webapp.service;

import com.example.webapp.domain.UserCart;
import com.example.webapp.dto.UserCartDto;

public interface UserCartService {
    UserCart createUser(UserCartDto newUser);
    UserCart updateUser(long id, UserCartDto user);
    UserCart deleteUser(long id);
    Iterable<UserCart> getUsers();
    UserCart getUserById(long id);
    UserCart addToCart(long id, long productId);
    UserCart deleteFromCart(long id, long productId);
}
