
package com.springrest.demo.services;

import java.util.List;

import com.springrest.demo.entities.Product;

public interface ProductService {

	public List<Product> getProducts();
	
	public Product getProduct(long productId);
	
	public Product addProduct(Product product);
}
