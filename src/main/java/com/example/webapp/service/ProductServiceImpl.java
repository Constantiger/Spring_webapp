package com.example.webapp.service;

import com.example.webapp.domain.ProductDto;
import com.example.webapp.domain.ProductFilter;
import com.example.webapp.domain.Product;
import com.example.webapp.error.ProductNotFoundException;
import com.example.webapp.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

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
        Sort.Direction sortOrder = ("desc".equals(filter.getSortOrder())) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Long    present = (filter.getPresent().equals(Boolean.TRUE)) ? 1L : 0L;
        if (type != null && !type.isEmpty()) {
            products = productRepo.findByProductTypeAndPriceBetweenAndAmountGreaterThanEqual(type, filter.getMinPrice(),
                            filter.getMaxPrice(), present, PageRequest.of(filter.getPage(), filter.getPageSize(),
                            Sort.by(sortOrder, filter.getSortBy())));
        } else {
            products = productRepo.findByPriceBetweenAndAmountGreaterThanEqual(filter.getMinPrice(), filter.getMaxPrice()
                            ,present, PageRequest.of(filter.getPage(), filter.getPageSize(),
                            Sort.by(sortOrder, filter.getSortBy())));
        }
        return products;
    }
}
