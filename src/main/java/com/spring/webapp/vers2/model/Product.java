package com.spring.webapp.vers2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product_table")
public class Product {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "type")
    private String type;

    @Column(name = "weight")
    private Long weight;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "available")
    private boolean available;


    public static class Builder {
        private final Long id;
        private final String name;
        private final Double price;
        private String type;
        private Long weight;
        private Long amount;
        private boolean available = true;

        public Builder(Long id, String name, Double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setWeight(Long weight) {
            this.weight = weight;
            return this;
        }

        public Builder setAmount(Long amount) {
            this.amount = amount;
            return this;
        }

        public Builder setAvailable(boolean available) {
            this.available = available;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.id = id;
            product.name = name;
            product.price = price;
            product.type = type;
            product.weight = weight;
            product.amount = amount;
            product.available = available;
            return product;
        }
    }
}
