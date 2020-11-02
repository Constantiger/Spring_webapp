package com.example.webapp.dto;

import lombok.Value;

@Value
public class ProductDto {
    String text;
    String productType;
    Long price;
    Long amount;
}
