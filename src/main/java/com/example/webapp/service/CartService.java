package com.example.webapp.service;
import com.example.webapp.domain.Cart;
import com.example.webapp.domain.Product;

public interface CartService {
    Cart createCart(Long id, Long[] productIds);
    Cart updateCart(Long id, Long[] productIds);
    Cart deleteCart(Long id);
    Iterable<Cart> getCarts();
    Cart getCartById(Long id);
    Iterable<Product> productsFromCartId(Long id);
}
