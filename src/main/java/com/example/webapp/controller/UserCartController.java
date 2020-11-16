package com.example.webapp.controller;

import com.example.webapp.dto.UserCartDto;
import com.example.webapp.dto.UserCartResponse;
import com.example.webapp.service.UserCartService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cart")
public class UserCartController {
    private final UserCartService userCartService;

    @GetMapping("/{id}")
    public UserCartResponse userCart(@PathVariable long id) {
        return userCartService.getUserCartById(id);
    }

    @GetMapping
    public Iterable<UserCartResponse> showAll() {
        return userCartService.getUserCarts();
    }

    @PostMapping
    public UserCartResponse addUser(@RequestBody UserCartDto newUserCart) {
        return userCartService.createUserCart(newUserCart);
    }

    @PutMapping("/{id}")
    public UserCartResponse updateUser(@PathVariable long id, @RequestBody UserCartDto updateUserCart) {
        return userCartService.updateUserCart(id, updateUserCart);
    }

    @DeleteMapping("/{id}")
    public UserCartResponse deleteUser(@PathVariable long id) {
        return userCartService.deleteUserCart(id);
    }

    @PutMapping("/{id}/product/{productId}")
    @ApiOperation(value = "Put several instances of product to user cart")
    public UserCartResponse addToCart(@PathVariable long id, @PathVariable long productId, int productAmount) {
        return userCartService.addToCart(id, productId, productAmount);
    }

    @DeleteMapping("/{id}/product/{productId}")
    @ApiOperation(value = "Delete ALL products with given Id from user cart")
    public UserCartResponse deleteFromCart(@PathVariable long id, @PathVariable long productId) {
        return userCartService.deleteFromCart(id, productId);
    }

    @PutMapping("/{id}/products")
    @ApiOperation(value = "Put list of products to user cart")
    public UserCartResponse addProductsToCart(@PathVariable long id, @RequestBody List<Long> productIds) {
        return userCartService.addProductsToCart(id, productIds);
    }

    @DeleteMapping("/{id}/products")
    @ApiOperation(value = "Remove list of products from user cart")
    public UserCartResponse deleteProductsFromCart(@PathVariable long id, @RequestBody List<Long> productIds) {
        return userCartService.deleteProductsFromCart(id, productIds);
    }

    @DeleteMapping("/{id}/all")
    public UserCartResponse removeAllProductsFromCart(@PathVariable long id) {
        return userCartService.removeAllProductsFromCart(id);
    }
}
