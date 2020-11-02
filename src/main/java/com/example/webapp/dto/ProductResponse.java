package com.example.webapp.dto;

import com.example.webapp.domain.Product;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class ProductResponse {
    Long id;
    String text;
    String productType;
    Long price;
    Long amount;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.text = product.getText();
        this.productType = product.getProductType();
        this.price = product.getPrice();
        this.amount = product.getAmount();
    }

    public static Iterable<ProductResponse> convert(Iterable<Product> products) {
        List<ProductResponse> responses = new ArrayList<>();
        products.forEach(product -> responses.add(new ProductResponse(product)));
        return responses;
    }
}
