package com.spring.webapp.vers2.dao;

import com.spring.webapp.vers2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface ProductDao extends CrudRepository<Product, Long>, JpaRepository<Product, Long> {
}
