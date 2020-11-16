package com.example.webapp.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user_cart")
public class UserCart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull
    private Long id;

    @Column(unique = true)
    @NotBlank
    private String username;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Product> cart;

    public void addToCart(Product product) {
            this.cart.add(product);
    }
    public void addToCart(Product product, int amount) { this.cart.addAll(Collections.nCopies(amount, product)); }
}
