package com.example.webapp.domain;

import org.springframework.data.jpa.domain.Specification;

public class ProductSpecs {
    private ProductSpecs() { }

    public static Specification<Product> productTypeIs(String productType) {
        return (root, query, builder) -> {
            if (productType != null)
                return builder.equal(root.get(Product_.productType), productType);
            else
                return builder.notEqual(root.get(Product_.productType), "");
        };
    }
    public static Specification<Product> priceBetween(Long min, Long max) {
        return (root, query, builder) -> builder.between(root.get(Product_.price), min, max);
    }
    public static Specification<Product> amountBiger(Long amount) {
        return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get(Product_.amount), amount);
    }

}
