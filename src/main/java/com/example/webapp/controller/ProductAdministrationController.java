package com.example.webapp.controller;

import com.example.webapp.domain.Product;
import com.example.webapp.domain.ProductFilter;
import com.example.webapp.dto.ProductDto;
import com.example.webapp.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProductAdministrationController {
    private final ProductService productService;

    @GetMapping("/product/{id}")
    @ApiOperation(value = "Find product by id",
                    notes = "required long integer ID",
                    response = Product.class)
    public Product productById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/product")
    @ApiOperation(value = "Get filtered products",
            notes = "filter all products by ProductType, amount, minimal and maximal price",
            response = Product.class,
            responseContainer = "List")
    public Iterable<Product> product(@ApiParam(value = "filter parameters.",
            defaultValue = "pageSize = 20",
            type = "ProductFilter",
            required = false)
                                                 ProductFilter filter) {
        return productService.getProducts(filter);
    }

    @GetMapping("/product/all")
    @ApiOperation(value = "Get all existing products",
            response = Product.class,
            responseContainer = "List")
    public Iterable<Product> allProduct() {
        return productService.getProducts();
    }

    @PostMapping("/product")
    @ApiOperation(value = "add product to database",
            notes = "required ProductDto with set productType, amount, price and description text",
            response = Product.class)
    public Product addProduct(@ApiParam(value = "ProductDto", required = true) @RequestBody ProductDto newProduct) {
        return productService.createProduct(newProduct);
    }

    @PutMapping("/product/{id}")
    @ApiOperation(value = "update product in database",
            notes = "required ProductDto with set productType, amount, price and description text",
            response = Product.class)
    public Product updateProduct(@PathVariable long id, @RequestBody ProductDto updateProduct) {
        return productService.updateProduct(id, updateProduct);
    }

    @DeleteMapping("/product/{id}")
    @ApiOperation(value = "Delete product by id",
            notes = "required long integer ID",
            response = Product.class)
    public Product deleteProduct(@PathVariable long id) {
        return productService.deleteProduct(id);
    }
}
