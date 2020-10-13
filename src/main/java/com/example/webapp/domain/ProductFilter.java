package com.example.webapp.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class ProductFilter {
    private String productType;
    private Long   maxPrice;
    private Long   minPrice;
    private Boolean present;
    private Integer page;

    public ProductFilter(String productType, Long maxPrice, Long minPrice, Boolean present, Integer page) {
        this.productType = productType;
        this.maxPrice = (maxPrice == null) ? Long.MAX_VALUE : maxPrice;
        this.minPrice = (minPrice == null) ? 0L : minPrice;
        this.present = (present == null) ? Boolean.FALSE : present;
        this.page = (page == null) ? 0 : page;
    }
}
