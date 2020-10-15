package com.example.webapp.controller;

import com.example.webapp.domain.Cart;
import com.example.webapp.domain.CartDto;
import com.example.webapp.domain.Product;
import com.example.webapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    private final CartService cartService;

    public CartController(@Autowired CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart/{id}")
    public Cart cartById(@PathVariable Long id) {
        return cartService.getCartById(id);
    }

    @GetMapping("/cart")
    public Iterable<Cart> cart() {
        return cartService.getCarts();
    }

    @PostMapping("/cart")
    public Cart addCart(@RequestBody CartDto cart) {
        return cartService.createCart(cart.getId(), cart.getProductIds());
    }

    @PutMapping("/cart/{id}")
    public Cart updateCart(@PathVariable Cart cart) {
        return cartService.updateCart(cart.getId(), cart.getProductIds());
    }

    @DeleteMapping("/cart/{id}")
    public Cart deleteCart(@RequestParam Long id) {
        return cartService.deleteCart(id);
    }

    @GetMapping("/product/cart{id}")
    public Iterable<Product> productsFromCart(@PathVariable Long id){
        return cartService.productsFromCartId(id);
    }

}
