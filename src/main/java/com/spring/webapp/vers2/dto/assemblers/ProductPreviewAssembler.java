package com.spring.webapp.vers2.dto.assemblers;

import com.spring.webapp.vers2.controller.rest.ProductRestController;
import com.spring.webapp.vers2.dto.ProductPreviewDto;
import com.spring.webapp.vers2.model.Product;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class ProductPreviewAssembler extends RepresentationModelAssemblerSupport<Product, ProductPreviewDto> {

    public ProductPreviewAssembler() {
        super(ProductRestController.class, ProductPreviewDto.class);
    }

    public ProductPreviewDto toModel(Product product) {
        ProductPreviewDto productPreviewDto = createModelWithId(product.getId(), product);
        productPreviewDto.setProductId(product.getId());
        productPreviewDto.setName(product.getName());
        productPreviewDto.setPrice(product.getPrice());
        return productPreviewDto;
    }
}
