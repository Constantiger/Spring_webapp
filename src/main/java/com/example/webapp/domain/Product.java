package com.example.webapp.domain;

import com.example.webapp.dto.ProductDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String  text;
    private String  productType;
    private Long    price;
    private Long    amount;

    public Product(String text, String productType, Long price, Long amount) {
        this.text = text;
        this.productType = productType;
        this.price = price;
        this.amount = amount;
    }

    public Product(ProductDto productDto) {
        this.text = productDto.getText();
        this.productType = productDto.getProductType();
        this.price = productDto.getPrice();
        this.amount = productDto.getAmount();
    }

    public void setProduct(ProductDto productDto) {
        this.setPrice(productDto.getPrice());
        this.setProductType(productDto.getProductType());
        this.setText(productDto.getText());
        this.setAmount(productDto.getAmount());
    }
}
