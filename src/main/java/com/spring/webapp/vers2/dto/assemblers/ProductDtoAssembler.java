package com.spring.webapp.vers2.dto.assemblers;

import com.spring.webapp.vers2.controller.rest.ProductRestController;
import com.spring.webapp.vers2.dto.ProductDto;
import com.spring.webapp.vers2.model.Product;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.lang.NonNullApi;

public class ProductDtoAssembler extends RepresentationModelAssemblerSupport<Product, ProductDto> {

    public ProductDtoAssembler() {
        super(ProductRestController.class, ProductDto.class);
    }

    @Override
    public ProductDto toModel(Product product) {
        ProductDto productDto = instantiateModel(product);
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setAmount(product.getAmount());
        productDto.setPrice(product.getPrice());
        productDto.setType(product.getType());
        productDto.setWeight(product.getWeight());
        productDto.setAvailable(product.isAvailable());
        return productDto;
    }

    public Product dtoToModel(ProductDto productDto) {
        return new Product.Builder(productDto.getId(), productDto.getName(), productDto.getPrice())
                .setAmount(productDto.getAmount())
                .setType(productDto.getType())
                .setWeight(productDto.getWeight())
                .setAvailable(productDto.isAvailable())
                .build();
    }
}
