package com.spring.webapp.vers2.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class ProductPreviewDto extends RepresentationModel<ProductPreviewDto> {
    private long productId;
    private String name;
    private Double price;
}
