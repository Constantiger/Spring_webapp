package com.example.webapp.service;

import com.example.webapp.domain.ProductDto;
import com.example.webapp.domain.ProductFilter;
import com.example.webapp.domain.Product;
import com.example.webapp.error.ProductNotFoundException;
import com.example.webapp.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
        if (id != null && productRepo.existsById(id)) {
            product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        } else {
            throw new ProductNotFoundException(id);
        }
        if (updateProduct.getPrice() != null)
            product.setPrice(updateProduct.getPrice());
        if (updateProduct.getProductType() != null)
            product.setProductType(updateProduct.getProductType());
        if (updateProduct.getText() != null)
            product.setText(updateProduct.getText());
        if (updateProduct.getAmount() != null)
            product.setAmount(updateProduct.getAmount());
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

    @Override
    public Iterable<Product> getProductsByFilter(ProductFilter filter) {
        Iterable<Product> products;
        String type = filter.getProductType();
        if (type != null && !type.isEmpty()) {
            products = productRepo.findByProductType(type, PageRequest.of(filter.getPage(),3));
        } else {
            products = productRepo.findAll();
        }
        products = StreamSupport.stream(products.spliterator(), false)
                .filter(p -> p.getPrice() >= filter.getMinPrice()
                            && p.getPrice() <= filter.getMaxPrice()
                            && !(p.getAmount() == 0 && filter.getPresent()))
                .collect(Collectors.toList());
        return products;
    }
}
