package com.example.webapp.domain;

import com.example.webapp.dto.UserCartDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
@Entity
@Table(name = "user_cart")
public class UserCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> cart;

    public UserCart(UserCartDto user) {
        this.username = user.getUsername();
        this.cart = new ArrayList<>();

    }

    public void addToCart(Product product) {
        this.cart.add(product);
    }
}
