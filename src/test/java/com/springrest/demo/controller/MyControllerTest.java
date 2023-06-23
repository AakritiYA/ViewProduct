package com.springrest.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.springrest.demo.entities.Product;

class MyControllerTest {

	@SuppressWarnings("deprecation")
	@Test
	void getProductById() {
		Product result;
		MyController controller;
		controller = new MyController();
		result = controller.getProductById(1L);
		Assert.isTrue(null != result);
	}
	
	@Test
	void getProductByIdTest() {
	    Product testProduct = new Product();
	    
	}
	
	@Test
	void getAllProductsTest() {
		
	}
	
}
