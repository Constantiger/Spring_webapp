package com.example.webapp.dao;

import lombok.*;

import javax.persistence.SecondaryTable;

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
