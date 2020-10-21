package com.example.webapp.dto;

import lombok.*;

@Value
public class CartDto {
    Long id;
    Long[] productIds;
}
