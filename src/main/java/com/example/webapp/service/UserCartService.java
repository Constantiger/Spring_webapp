package com.example.webapp.service;

import com.example.webapp.dto.UserCartDto;
import com.example.webapp.dto.UserCartResponse;

import java.util.List;

public interface UserCartService {
    UserCartResponse createUser(UserCartDto newUser);
    UserCartResponse updateUser(long id, UserCartDto user);
    UserCartResponse deleteUser(long id);
    Iterable<UserCartResponse> getUsers();
    UserCartResponse getUserById(long id);
    UserCartResponse addToCart(long id, long productId);
    UserCartResponse addProductsToCart(long id, List<Long> productIds);
    UserCartResponse deleteFromCart(long id, long productId);
    UserCartResponse deleteProductsFromCart(long id, List<Long> productIds);
    UserCartResponse removeAllProductsFromCart(long id);
}
