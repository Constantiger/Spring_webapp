package com.example.webapp.service;

import com.example.webapp.domain.Product;
import com.example.webapp.domain.UserCart;
import com.example.webapp.dto.UserCartDto;

public interface UserCartService {
    UserCart createUser(UserCartDto newUser);
    UserCart updateUser(Long id, UserCartDto user);
    UserCart deleteUser(Long id);
    Iterable<UserCart> getUsers();
    UserCart getUserById(Long id);
    UserCart addToCart(Long id, Long productid);
    Iterable<Product> productFromCart(Long id);
    UserCart deleteFromCart(Long id, Long productid);
}
