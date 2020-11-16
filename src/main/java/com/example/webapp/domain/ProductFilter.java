package com.example.webapp.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@ApiModel(value = "Parameters o filtering", description = "Return list of all products fit the criteria")
public class ProductFilter {
    @ApiModelProperty(dataType = "String")
    @NotBlank
    private String productType;

    @ApiModelProperty(value = "Maximum price product have", dataType = "Long", allowableValues = "range[1, infinity]")
    @Positive
    private Long maxPrice;

    @ApiModelProperty(value = "Minimum price product have", dataType = "Long", allowableValues = "range[0, infinity]")
    @PositiveOrZero
    private Long minPrice;

    @ApiModelProperty(value = "Amount of products available", dataType = "Long", allowableValues = "range[0, infinity]")
    @PositiveOrZero
    private Long minAmount;

    @ApiModelProperty(value = "Number of products needs to get at once", dataType = "Integer", allowableValues = "range[0, infinity]")
    @PositiveOrZero
    private Integer pageSize;

    @ApiModelProperty(value = "Number of page needs to get", dataType = "Integer", allowableValues = "range[0, infinity]")
    @PositiveOrZero
    private Integer page;

    @ApiModelProperty(value = "Set field of Product to sort by", dataType = "String", example = "price")
    private String sortBy;

    @ApiModelProperty(value = "Sort order. 'desc' for descending order, 'asc' and else for ascending order", dataType = "String")
    private String sortOrder;

    private Sort.Direction sortDir;

    public ProductFilter(String productType, Long maxPrice, Long minPrice, Long minAmount,
                         Integer page, Integer pageSize, String sortBy, String sortOrder) {
        this.productType = productType;
        this.maxPrice = (maxPrice == null) ? Long.MAX_VALUE : maxPrice;
        this.minPrice = (minPrice == null) ? 0L : minPrice;
        this.minAmount = (minAmount == null) ? 0L : minAmount;
        this.page = (page == null) ? 0 : page;
        this.pageSize = (pageSize == null) ? Integer.MAX_VALUE : pageSize;
        this.sortBy = (sortBy == null) ? "id" : sortBy;
        this.sortOrder = (sortOrder == null) ? "asc" : sortOrder;
        this.sortDir = ("desc".equals(this.sortOrder)) ? Sort.Direction.DESC : Sort.Direction.ASC;
    }

    public static Pageable pageRequest(ProductFilter filter) {
        return PageRequest.of(filter.getPage(), filter.getPageSize(), Sort.by(filter.getSortDir(), filter.getSortBy()));
    }
}
