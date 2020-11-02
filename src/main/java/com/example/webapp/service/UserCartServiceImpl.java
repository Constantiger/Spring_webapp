package com.example.webapp.service;

import com.example.webapp.domain.Product;
import com.example.webapp.domain.UserCart;
import com.example.webapp.dto.UserCartDto;
import com.example.webapp.error.UserExistsException;
import com.example.webapp.error.UserNotFoundException;
import com.example.webapp.repos.UserCartRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserCartServiceImpl implements UserCartService {
    private final UserCartRepo userCartRepo;
    private final ProductService productService;

    @Override
    public UserCart createUser(UserCartDto newUser) {
        if (userCartRepo.findByUsername(newUser.getUsername()) != null) {
            throw new UserExistsException(newUser.getUsername());
        }
        return userCartRepo.save(UserCartDto.getNewUserCart(newUser));
    }

    @Override
    public UserCart updateUser(long id, UserCartDto updateUser) {
        UserCart user = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setUsername(updateUser.getUsername());
        return userCartRepo.save(user);
    }

    @Override
    public UserCart deleteUser(long id) {
        UserCart user = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        userCartRepo.deleteById(id);
        return user;
    }

    @Override
    public Iterable<UserCart> getUsers() {
        return userCartRepo.findAll();
    }

    @Override
    public UserCart getUserById(long id) {
        return userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public UserCart addToCart(long id, long productId){
        UserCart user = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        Product product = productService.getProductById(productId);
        user.addToCart(product);
        return userCartRepo.save(user);
    }

    @Override
    public UserCart addProductsToCart(long id, List<Long> productIds) {
        UserCart user = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        productIds.forEach(productId -> user.addToCart(productService.getProductById(productId)));
        return userCartRepo.save(user);
    }

    @Override
    public UserCart deleteFromCart(long id, long productId){
        UserCart user = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.getCart().removeIf(pid -> pid.getId().equals(productId));
        return userCartRepo.save(user);
    }

    @Override
    public UserCart deleteProductsFromCart(long id, List<Long> productIds) {
        UserCart user = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        productIds.forEach(productId -> user.getCart().remove(productService.getProductById(productId)));
        return userCartRepo.save(user);
    }

    @Override
    public UserCart removeAllProductsFromCart(long id) {
        UserCart user = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.getCart().clear();
        return userCartRepo.save(user);
    }
}
