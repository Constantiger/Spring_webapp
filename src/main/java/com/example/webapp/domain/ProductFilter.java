package com.example.webapp.domain;

import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class ProductFilter {
    private String productType;
    private Long maxPrice;
    private Long minPrice;
    private Long minAmount;
    private Integer page;
    private Integer pageSize;
    private String sortBy;
    private String sortOrder;
    private Sort.Direction sortDir;

    public ProductFilter(String productType, Long maxPrice, Long minPrice, Long minAmount,
                         Integer page, Integer pageSize, String sortBy, String sortOrder) {
        this.productType = productType;
        this.maxPrice = (maxPrice == null) ? Long.MAX_VALUE : maxPrice;
        this.minPrice = (minPrice == null) ? 0L : minPrice;
        this.minAmount = (minAmount == null) ? 0L : minAmount;
        this.page = (page == null) ? 0 : page;
        this.pageSize = (pageSize == null) ? 20 : pageSize;
        this.sortBy = (sortBy == null) ? "id" : sortBy;
        this.sortOrder = (sortOrder == null) ? "asc" : sortOrder;
        this.sortDir = ("desc".equals(this.sortOrder)) ? Sort.Direction.DESC : Sort.Direction.ASC;
    }

    public static Pageable pageRequest(ProductFilter filter) {
        return PageRequest.of(filter.getPage(), filter.getPageSize(), Sort.by(filter.getSortDir(), filter.getSortBy()));
    }
}
