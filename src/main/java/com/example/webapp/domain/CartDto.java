package com.example.webapp.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class CartDto {
    private Long id;
    private Long[] productIds;
}
