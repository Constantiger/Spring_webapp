package com.spring.webapp.vers2.service;

import com.spring.webapp.vers2.dao.ProductDao;
import com.spring.webapp.vers2.exception.UnknownEntityException;
import com.spring.webapp.vers2.model.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService{
    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDAO) {
        this.productDao = productDAO;
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll().stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
    }

    @Override
    public Product getProduct(long productId) throws UnknownEntityException {
        return productDao.findById(productId)
                .orElseThrow(() -> new UnknownEntityException(Product.class, productId));
    }

    @Override
    public Optional<Product> findById(long productId) {
        return productDao.findById(productId);
    }

    @Override
    public void create(Product product) {
        saveInternal(product, true);
    }

    @Override
    public void update(Long productId, Product product) throws UnknownEntityException {
        Product original = getProduct(productId);
        product.setId(original.getId());
        saveInternal(product, original.isAvailable());
    }

    private void saveInternal(Product changed, boolean available) {
        changed.setAvailable(available);
        productDao.save(changed);
    }

    @Override
    public void delete(Long productId) {
        productDao.deleteById(productId);
    }

}
