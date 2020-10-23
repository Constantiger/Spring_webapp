package com.spring.webapp.vers2.controller.rest;

import com.spring.webapp.vers2.dto.ProductDto;
import com.spring.webapp.vers2.dto.ProductPreviewDto;
import com.spring.webapp.vers2.dto.assemblers.ProductDtoAssembler;
import com.spring.webapp.vers2.dto.assemblers.ProductPreviewAssembler;
import com.spring.webapp.vers2.exception.UnknownEntityException;
import com.spring.webapp.vers2.model.Product;
import com.spring.webapp.vers2.service.ProductService;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/rest/priducts")
@ExposesResourceFor(ProductDto.class)
public class ProductRestController {
    private final ProductService productService;
    private final ProductPreviewAssembler productPreviewAssembler = new ProductPreviewAssembler();
    private final ProductDtoAssembler productDtoAssembler = new ProductDtoAssembler();

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Collection<ProductPreviewDto> getProducts() {
        return productService.findAll().stream()
                .sorted(Comparator.comparing(Product::getId))
                .map(productPreviewAssembler::toModel)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ProductDto getProduct(@PathVariable long id) throws UnknownEntityException {
        return productService.findById(id)
                .map(productDtoAssembler::toModel)
                .orElseThrow(() -> new UnknownEntityException(Product.class, id));
    }

}
