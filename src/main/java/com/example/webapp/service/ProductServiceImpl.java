package com.example.webapp.service;

import com.example.webapp.domain.Product;
import com.example.webapp.domain.ProductFilter;
import com.example.webapp.dto.ProductDto;
import com.example.webapp.error.ProductNotFoundException;
import com.example.webapp.repos.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.webapp.domain.ProductSpecs.specificationByFilter;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public Product createProduct(ProductDto newProduct) {
        Product product = new Product(newProduct);
        productRepo.save(product);
        return product;
    }

    @Override
    public Product updateProduct(long id, ProductDto updateProduct){
        Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        product.setProduct(updateProduct);
        productRepo.save(product);
        return product;
    }

    @Override
    public Product deleteProduct(long id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        productRepo.deleteById(id);
        return product;
    }

    @Override
    public Iterable<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(long id) {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Iterable<Product> getProductById(Iterable<Long> ids) {
        return productRepo.findAllById(ids);
    }

    @Override
    public Iterable<Product> getProducts(ProductFilter filter) {
        return productRepo.findAll(
                specificationByFilter(filter),
                ProductFilter.pageRequest(filter)).toList();
    }
}
