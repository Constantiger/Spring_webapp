package com.example.webapp.domain;

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

    private String text;
    private String prodtype;
    private Long price;

    public Product(String text, String prodtype, long price) {
        this.text = text;
        this.prodtype = prodtype;
        this.price = price;
    }
}
