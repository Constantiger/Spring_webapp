package com.busylessman.shop.product;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductDtoConverter implements Converter<Product, ProductDto> {

    public ProductDto convert(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice());
    }
}
