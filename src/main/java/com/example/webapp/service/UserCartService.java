package com.example.webapp.service;

import com.example.webapp.dto.UserCartDto;
import com.example.webapp.dto.UserCartResponse;
import java.util.List;

public interface UserCartService {
    UserCartResponse createUserCart(UserCartDto newUser);
    UserCartResponse updateUserCart(long id, UserCartDto user);
    UserCartResponse deleteUserCart(long id);
    Iterable<UserCartResponse> getUserCarts();
    UserCartResponse getUserCartById(long id);
    UserCartResponse addToCart(long id, long productId, int amount);
    UserCartResponse addProductsToCart(long id, List<Long> productIds);
    UserCartResponse deleteFromCart(long id, long productId);
    UserCartResponse deleteProductsFromCart(long id, List<Long> productIds);
    UserCartResponse removeAllProductsFromCart(long id);
}
