package com.example.webapp.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
public class ProductFilter {
    private String productType;
    private Long   maxPrice;
    private Long   minPrice;
    private Boolean present;
}
