package com.example.webapp.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @NotNull
    private Long id;

    @Lob
    private String  text;

    @NotBlank
    private String  productType;

    @Positive
    @NotNull
    private Long    price;

    @PositiveOrZero
    @NotNull
    private Long    amount;
}
