package com.example.webapp.service;

import com.example.webapp.domain.Product;
import com.example.webapp.domain.UserCart;
import com.example.webapp.dto.UserCartDto;
import com.example.webapp.dto.UserCartResponse;
import com.example.webapp.error.UserExistsException;
import com.example.webapp.error.UserNotFoundException;
import com.example.webapp.mapper.UserCartResponseMapper;
import com.example.webapp.repos.UserCartRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCartServiceImpl implements UserCartService {
    private final UserCartRepo userCartRepo;
    private final ProductService productService;
    private final UserCartResponseMapper mapper;

    @Override
    public UserCartResponse createUserCart(UserCartDto newUser) {
        try {
            return mapper.userCartToUserCartResponse(userCartRepo.save(mapper.userCartDtoToUserCart(newUser)));
        } catch (RuntimeException exception) {
            throw new UserExistsException(newUser.getUsername());
        }
    }

    @Override
    @Transactional
    public UserCartResponse updateUserCart(long id, UserCartDto updateUser) {
        UserCart user = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setUsername(updateUser.getUsername());
        return mapper.userCartToUserCartResponse(userCartRepo.save(user));
    }

    @Override
    @Transactional
    public UserCartResponse deleteUserCart(long id) {
        UserCart user = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        userCartRepo.deleteById(id);
        return mapper.userCartToUserCartResponse(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<UserCartResponse> getUserCarts() {
        return mapper.listOfUserCartResponse(userCartRepo.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public UserCartResponse getUserCartById(long id) {
        return mapper.userCartToUserCartResponse(userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }

    @Override
    @Transactional
    public UserCartResponse addToCart(long id, long productId, int amount){
        UserCart userCart = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        Product product = productService.getProductById(productId);
        userCart.addToCart(product, amount);
        return mapper.userCartToUserCartResponse(userCartRepo.save(userCart));
    }

    @Override
    @Transactional
    public UserCartResponse addProductsToCart(long id, List<Long> productIds) {
        UserCart user = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        productIds.forEach(productId -> user.addToCart(productService.getProductById(productId)));
        return mapper.userCartToUserCartResponse(userCartRepo.save(user));
    }

    @Override
    @Transactional
    public UserCartResponse deleteFromCart(long id, long productId){
        UserCart user = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.getCart().removeIf(pid -> pid.getId().equals(productId));
        return mapper.userCartToUserCartResponse(userCartRepo.save(user));
    }

    @Override
    @Transactional
    public UserCartResponse deleteProductsFromCart(long id, List<Long> productIds) {
        UserCart user = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        productIds.forEach(productId -> user.getCart().remove(productService.getProductById(productId)));
        return mapper.userCartToUserCartResponse(userCartRepo.save(user));
    }

    @Override
    @Transactional
    public UserCartResponse removeAllProductsFromCart(long id) {
        UserCart user = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.getCart().clear();
        return mapper.userCartToUserCartResponse(userCartRepo.save(user));
    }
}
