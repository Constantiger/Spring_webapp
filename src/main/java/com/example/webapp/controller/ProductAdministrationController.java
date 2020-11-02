package com.example.webapp.controller;

import com.example.webapp.domain.Product;
import com.example.webapp.domain.ProductFilter;
import com.example.webapp.dto.ProductDto;
import com.example.webapp.dto.ProductResponse;
import com.example.webapp.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductAdministrationController {
    private final ProductService productService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Find product by id",
                    notes = "required long integer ID")
    public ProductResponse productById(@PathVariable long id) {
        return productService.getProductById(id).toProductResponse();
    }

    @GetMapping()
    @ApiOperation(value = "Get filtered products",
            notes = "filter all products by ProductType, amount, minimal and maximal price",
            response = Product.class)
    public Iterable<ProductResponse> product(@ApiParam(value = "filter parameters.", defaultValue = "pageSize = 20", required = false)
                                                 ProductFilter filter) {
        return ProductResponse.convert(productService.getProducts(filter));
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all existing products",
            response = Product.class)
    public Iterable<ProductResponse> allProduct() {
        return ProductResponse.convert(productService.getProducts());
    }

    @PostMapping()
    @ApiOperation(value = "add product to database",
            notes = "required ProductDto with set productType, amount, price and description text",
            response = Product.class)
    public ProductResponse addProduct(@ApiParam(value = "ProductDto", required = true) @RequestBody ProductDto newProduct) {
        return productService.createProduct(newProduct).toProductResponse();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "update product in database",
            notes = "required ProductDto with set productType, amount, price and description text")
    public ProductResponse updateProduct(@PathVariable long id, @RequestBody ProductDto updateProduct) {
        return productService.updateProduct(id, updateProduct).toProductResponse();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete product by id",
            notes = "required long integer ID")
    public ProductResponse deleteProduct(@PathVariable long id) {
        return productService.deleteProduct(id).toProductResponse();
    }
}
