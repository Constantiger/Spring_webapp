package com.example.webapp.service;

import com.example.webapp.domain.Cart;
import com.example.webapp.domain.Product;
import com.example.webapp.error.ProductNotFoundException;
import com.example.webapp.repos.CartRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepo cartRepo;
    private final ProductService productService;

    @Override
    public Cart createCart(Long id, Long[] productIds) {
        Cart cart = new Cart(id, productIds);
        cartRepo.save(cart);
        return cart;
    }

    @Override
    public Cart updateCart(Long id, Long[] productIds) {
        Cart cart = cartRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        cart.setProductIds(productIds);
        cartRepo.save(cart);
        return cart;
    }

    @Override
    public Cart deleteCart(Long id) {
        Cart cart = cartRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        cartRepo.deleteById(id);
        return cart;
    }

    @Override
    public Iterable<Cart> getCarts() {
        return cartRepo.findAll();
    }

    @Override
    public Cart getCartById(Long id) {
        return cartRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Iterable<Product> productsFromCartId(Long id) {
        Cart cart = cartRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        return productService.getProductById(Arrays.asList(cart.getProductIds()));
    }
}
