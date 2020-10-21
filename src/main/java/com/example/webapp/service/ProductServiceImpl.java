package com.example.webapp.service;

import com.example.webapp.domain.Product;
import com.example.webapp.domain.ProductFilter;
import com.example.webapp.dto.ProductDto;
import com.example.webapp.error.ProductNotFoundException;
import com.example.webapp.repos.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static com.example.webapp.domain.ProductSpecs.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public Product createProduct(ProductDto newProduct) {
        Product product = new Product(newProduct.getText(), newProduct.getProductType(), newProduct.getPrice(), newProduct.getAmount());
        productRepo.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Long id, ProductDto updateProduct){
        Product product;
        product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        product.setProduct(updateProduct);
        productRepo.save(product);
        return product;
    }

    @Override
    public Product deleteProduct(Long id) {
        Product product;
        product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        productRepo.deleteById(id);
        return product;
    }

    @Override
    public Iterable<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Iterable<Product> getProductById(Iterable<Long> ids) {
        return productRepo.findAllById(ids);
    }

    @Override
    public Iterable<Product> getProductsByFilter(ProductFilter filter) {
        Iterable<Product> products;
        String type = filter.getProductType();

        if (type != null && !type.isEmpty()) {
            products = productRepo.findByProductTypeAndPriceBetweenAndAmountGreaterThanEqual(type, filter.getMinPrice(),
                            filter.getMaxPrice(), filter.getMinAmount(), PageRequest.of(filter.getPage(), filter.getPageSize(),
                            Sort.by(filter.getSortDir(), filter.getSortBy())));
        } else {
            products = productRepo.findByPriceBetweenAndAmountGreaterThanEqual(filter.getMinPrice(), filter.getMaxPrice()
                            ,filter.getMinAmount(), PageRequest.of(filter.getPage(), filter.getPageSize(),
                            Sort.by(filter.getSortDir(), filter.getSortBy())));
        }
        return products;
    }

    @Override
    public Iterable<Product> getProducts(ProductFilter filter) {
        return productRepo.findAll(
                productTypeIs(filter.getProductType())
                        .and(priceBetween(filter.getMinPrice(), filter.getMaxPrice())
                        .and(amountBiger(filter.getMinAmount()))),
                PageRequest.of(filter.getPage(), filter.getPageSize(), Sort.by(filter.getSortDir(), filter.getSortBy()))).toList();
    }
}
