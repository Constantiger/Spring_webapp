package com.example.webapp.controller;

import com.example.webapp.domain.UserCart;
import com.example.webapp.dto.UserCartDto;
import com.example.webapp.service.UserCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/userCart")
public class UserCartController {
    private final UserCartService userCartService;

    @GetMapping("/{id}")
    public UserCart show(@PathVariable long id) {
        return userCartService.getUserById(id);
    }

    @GetMapping()
    public Iterable<UserCart> showAll() {
        return userCartService.getUsers();
    }

    @PostMapping()
    public UserCart addUser(@RequestBody UserCartDto newUser) {
        return userCartService.createUser(newUser);
    }

    @PutMapping("/{id}")
    public UserCart updateUser(@PathVariable long id, @RequestBody UserCartDto updateUser) {
        return userCartService.updateUser(id, updateUser);
    }

    @DeleteMapping("/{id}")
    public UserCart deleteUser(@PathVariable long id) {
        return userCartService.deleteUser(id);
    }

    @PutMapping("/{id}/product/{productId}")
    public UserCart addToCart(@PathVariable long id, @PathVariable long productId) {
        return userCartService.addToCart(id, productId);
    }

    @DeleteMapping("/{id}/product/{productId}")
    public UserCart deleteFromCart(@PathVariable long id, @PathVariable long productId) {
        return userCartService.deleteFromCart(id, productId);
    }

    @PutMapping("/{id}/products")
    public UserCart addProductsToCart(@PathVariable long id, @RequestBody List<Long> productIds) {
        return userCartService.addProductsToCart(id, productIds);
    }

    @DeleteMapping("/{id}/products")
    public UserCart deleteProductsFromCart(@PathVariable long id, @RequestBody List<Long> productIds) {
        return userCartService.deleteProductsFromCart(id, productIds);
    }

    @DeleteMapping("/{id}/all")
    public UserCart removeAllProductsFromCart(@PathVariable long id) {
        return userCartService.removeAllProductsFromCart(id);
    }
}
