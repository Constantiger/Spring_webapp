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
    private String prodtype;
    private Long price;

    public ProductDao(String text, String prodtype, long price) {
        this.text = text;
        this.prodtype = prodtype;
        this.price = price;
    }
}
