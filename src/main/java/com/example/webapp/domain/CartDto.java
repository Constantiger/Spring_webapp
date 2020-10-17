package com.example.webapp.domain;

import lombok.*;

@Value
public class CartDto {
    Long id;
    Long[] productIds;
}
