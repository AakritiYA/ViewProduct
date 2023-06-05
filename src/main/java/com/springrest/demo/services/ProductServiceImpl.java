package com.springrest.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.demo.dao.ProductDao;
import com.springrest.demo.entities.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	
	@Override
	public List<Product> getProducts() {
		return productDao.findAll();
	}


	@Override
	public Product getProduct(long productId) {
	    Optional<Product> optionalProduct = productDao.findById(productId);
	    return optionalProduct.orElse(null); 	
	}


	@Override
	public Product addProduct(Product product) {
		productDao.save(product);
		return product;
	}

}
