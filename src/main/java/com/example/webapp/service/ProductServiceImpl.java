package com.example.webapp.service;

import com.example.webapp.domain.Product;
import com.example.webapp.domain.ProductFilter;
import com.example.webapp.dto.ProductDto;
import com.example.webapp.dto.ProductResponse;
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
    public ProductResponse createProduct(ProductDto newProduct) {
        Product product = new Product(newProduct);
        productRepo.save(product);
        return product.toProductResponse();
    }

    @Override
    public ProductResponse updateProduct(long id, ProductDto updateProduct){
        Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        product.setProduct(updateProduct);
        productRepo.save(product);
        return product.toProductResponse();
    }

    @Override
    public ProductResponse deleteProduct(long id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        productRepo.deleteById(id);
        return product.toProductResponse();
    }

    @Override
    public Iterable<ProductResponse> getProducts() {
        return ProductResponse.convert(productRepo.findAll());
    }

    @Override
    public Product getProductById(long id) {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public ProductResponse getProductResponseById(long id) {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id)).toProductResponse();
    }

    @Override
    public Iterable<ProductResponse> getProductById(Iterable<Long> ids) {
        return ProductResponse.convert(productRepo.findAllById(ids));
    }

    @Override
    public Iterable<ProductResponse> getProducts(ProductFilter filter) {
        return ProductResponse.convert(productRepo.findAll(
                specificationByFilter(filter),
                ProductFilter.pageRequest(filter)).toList());
    }
}
