package com.example.webapp.dao;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class ProductDao {
    private String text;
    private String productType;
    private Long price;
    private Long amount;

    public ProductDao(String text, String productType, Long price, Long amount) {
        this.text = text;
        this.productType = productType;
        this.price = price;
        this.amount = amount;
    }
}
