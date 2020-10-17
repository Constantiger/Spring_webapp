package com.example.webapp.domain;

import lombok.*;

@Value
public class ProductDto {
    String text;
    String productType;
    Long price;
    Long amount;

    public ProductDto(String text, String productType, Long price, Long amount) {
        this.text = text;
        this.productType = productType;
        this.price = price;
        this.amount = amount;
    }
}
