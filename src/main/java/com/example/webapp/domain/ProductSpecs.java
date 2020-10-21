package com.example.webapp.domain;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductSpecs {
    public static Specification<Product> productTypeIs(String productType) {
        return new Specification<Product>() {
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                if (productType != null)
                    return builder.equal(root.get(Product_.productType), productType);
                else
                    return builder.notEqual(root.get(Product_.productType), "");
            }
        };
    }
    public static Specification<Product> priceBetween(Long min, Long max) {
        return new Specification<Product>() {
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                return builder.between(root.get(Product_.price), min, max);
            }
        };
    }
    public static Specification<Product> amountBiger(Long amount) {
        return new Specification<Product>() {
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                return builder.greaterThanOrEqualTo(root.get(Product_.amount), amount);
            }
        };
    }

}
