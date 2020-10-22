package com.example.webapp.service;

import com.example.webapp.domain.Product;
import com.example.webapp.domain.UserCart;
import com.example.webapp.dto.UserCartDto;
import com.example.webapp.error.UserExistsException;
import com.example.webapp.error.UserNotFoundException;
import com.example.webapp.repos.UserCartRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


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
        UserCart user = new UserCart(newUser);
        userCartRepo.save(user);
        return user;
    }

    @Override
    public UserCart updateUser(Long id, UserCartDto updateUser) {
        UserCart user;
        if (id != null && userCartRepo.existsById(id)) {
            user = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        } else {
            throw new UserNotFoundException(id);
        }
        user.setUsername(updateUser.getUsername());
        userCartRepo.save(user);
        return user;
    }

    @Override
    public UserCart deleteUser(Long id) {
        UserCart user;
        if (id != null && userCartRepo.existsById(id)) {
            user = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
            userCartRepo.deleteById(id);
            return user;
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public Iterable<UserCart> getUsers() {
        return userCartRepo.findAll();
    }

    @Override
    public UserCart getUserById(Long id) {
        return userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public UserCart addToCart(Long id, Long productid){
        UserCart user = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        Product product = productService.getProductById(productid);
        user.getCart().add(product);
        userCartRepo.save(user);
        return  user;
    }

    @Override
    public Iterable<Product> productFromCart(Long id) {
        UserCart user = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException((id)));
        return user.getCart();
    }

    @Override
    public UserCart deleteFromCart(Long id, Long productid){
        UserCart user = userCartRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.getCart().removeIf(pid -> pid.getId().equals(productid));
        userCartRepo.save(user);
        return user;
    }
}
