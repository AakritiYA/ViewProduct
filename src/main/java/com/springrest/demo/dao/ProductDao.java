package com.springrest.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.demo.entities.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
	
//    List<Product> findAll();
//    
//    Product findById(long productId);
//    
//    Product save(Product product);
}
