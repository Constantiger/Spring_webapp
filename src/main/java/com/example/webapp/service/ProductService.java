//package com.example.webapp.service;
//
//import com.example.webapp.model.Product;
//import com.example.webapp.error.ProductNotFoundException;
//import com.example.webapp.repos.ProductRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProductService {
//    @Autowired
//    private ProductRepo productRepo;
//    @PreAuthorize("hasAuthority('user:write')")
//    public Product createProduct(String text, String prodtype, long price) {
//        Product product = new Product(text, prodtype, price);
//        productRepo.save(product);
//        return product;
//    }
//    @PreAuthorize("hasAuthority('user:write')")
//    public void updateProduct(String id, Product product){
//
//    }
//    @PreAuthorize("hasAuthority('user:write')")
//    public Product deleteProduct(Long id) {
//        Product product;
//        if (id != null && productRepo.existsById(id)) {
//            product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
//            productRepo.deleteById(id);
//            return product;
//        } else {
//            throw new ProductNotFoundException(id);
//        }
//    }
//
//    @PreAuthorize("hasAuthority('user:read')")
//    public Iterable<Product> getProducts() {
//        return productRepo.findAll();
//    }
//
//    @PreAuthorize("hasAuthority('user:read')")
//    public Product getProductById(Long id) {
//        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
//    }
//
//    public Iterable<Product> getProductsByProdtype(String prodtype) {
//        Iterable<Product> products;
//        if (prodtype != null && !prodtype.isEmpty()) {
//            products = productRepo.findByProdtype(prodtype);
//        } else {
//            products = productRepo.findAll();
//        }
//        return products;
//    }
//}
