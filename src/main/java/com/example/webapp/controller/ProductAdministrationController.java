package com.example.webapp.controller;

import com.example.webapp.domain.ProductFilter;
import com.example.webapp.dto.ProductDto;
import com.example.webapp.dto.ProductResponse;
import com.example.webapp.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductAdministrationController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public ProductResponse productById(@PathVariable long id) {
        return productService.getProductResponseById(id);
    }

    @GetMapping
    @ApiOperation(value = "Get filtered products", notes = "Filter all products by ProductType, amount, minimal and maximal price. Sorting order and field to sort by can be define")
    public Iterable<ProductResponse> product(ProductFilter filter) {
        return productService.getProducts(filter);
    }

    @PostMapping
    public ProductResponse addProduct(@RequestBody ProductDto newProduct) {
        return productService.createProduct(newProduct);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable long id, @RequestBody ProductDto updateProduct) {
        return productService.updateProduct(id, updateProduct);
    }

    @DeleteMapping("/{id}")
    public ProductResponse deleteProduct(@PathVariable long id) {
        return productService.deleteProduct(id);
    }
}
