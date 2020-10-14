package com.busylessman.shop.product;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductControllerImpl {
    ProductService productService;

    @GetMapping("${id}")
    public ProductDto get(@PathVariable("id") Long id) {
        return productService.get(id);
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) {
        return productService.create(productDto);
    }

    @PostMapping
    public ProductDto update(@RequestBody ProductDto productDto) {
        return productService.update(productDto);
    }

    @DeleteMapping
    public void delete(@PathVariable("id") Long id) {
        productService.delete(id);
    }
}
