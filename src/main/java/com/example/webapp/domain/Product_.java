package com.example.webapp.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Product.class)
public class Product_ {
    public static volatile SingularAttribute<Product, Long> id;
    public static volatile SingularAttribute<Product, String> text;
    public static volatile SingularAttribute<Product, String> productType;
    public static volatile SingularAttribute<Product, Long> price;
    public static volatile SingularAttribute<Product, Long> amount;
}
