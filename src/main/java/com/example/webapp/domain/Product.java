package com.example.webapp.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String  text;
    private String  productType;
    private Long    price;
    private Long    amount;

    public Product(String text, String productType, Long price, Long amount) {
        this.text = text;
        this.productType = productType;
        this.price = price;
        this.amount = amount;
    }
}
