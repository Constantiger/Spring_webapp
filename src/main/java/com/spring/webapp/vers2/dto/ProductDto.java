package com.spring.webapp.vers2.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class ProductDto extends RepresentationModel<ProductDto> {
    private Long id;
    private String name;
    private Double price;
    private String type;
    private Long weight;
    private Long amount;
    private boolean available;
}
