package com.example.webapp.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
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

    public Product() {
    }

    /*
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getProdtype() {
        return prodtype;
    }

    public void setProdtype(String prodtype) {
        this.prodtype = prodtype;
    } */
}
