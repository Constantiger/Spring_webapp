package com.example.webapp.service;

import com.example.webapp.dao.ProductDao;
import com.example.webapp.dao.ProductFilter;
import com.example.webapp.domain.Product;
import com.example.webapp.error.ProductNotFoundException;
import com.example.webapp.repos.ProductRepo;
import com.google.common.collect.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product createProduct(ProductDao newProduct) {
        Product product = new Product(newProduct.getText(), newProduct.getProdtype(), newProduct.getPrice());
        productRepo.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Long id, ProductDao updateProduct){
        Product product;
        if (id != null && productRepo.existsById(id)) {
            product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        } else {
            throw new ProductNotFoundException(id);
        }
        product.setPrice(updateProduct.getPrice());
        product.setProdtype(updateProduct.getProdtype());
        product.setText(updateProduct.getText());
        productRepo.save(product);
        return product;
    }

    @Override
    public Product deleteProduct(Long id) {
        Product product;
        if (id != null && productRepo.existsById(id)) {
            product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
            productRepo.deleteById(id);
            return product;
        } else {
            throw new ProductNotFoundException(id);
        }
    }

    @Override
    public Iterable<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

/*
    public Iterable<Product> getProductsByProdtype(String prodtype) {
        Iterable<Product> products;
        if (prodtype != null && !prodtype.isEmpty()) {
            products = productRepo.findByProdtype(prodtype);
        } else {
            products = productRepo.findAll();
        }
        return products;
    }
*/
    @Override
    public Iterable<Product> getProductsByFilter(ProductFilter filter) {
        Iterable<Product> products;
        String type = filter.getProductType();
        if (type != null && !type.isEmpty()) {
            products = productRepo.findByProdtype(type);
        } else {
            products = productRepo.findAll();
        }
        if (filter.getMinPrice() == null) {
            filter.setMinPrice(0L);
        }
        if (filter.getMaxPrice() == null) {
            filter.setMaxPrice(Long.MAX_VALUE);
        }
        products = StreamSupport.stream(products.spliterator(), false)
                .filter((p) -> p.getPrice() > filter.getMinPrice() && p.getPrice() < filter.getMaxPrice())
                .collect(Collectors.toList());
        return products;
    }
}
