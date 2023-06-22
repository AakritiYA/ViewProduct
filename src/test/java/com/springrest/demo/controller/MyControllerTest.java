package com.springrest.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.springrest.demo.entities.Product;

class MyControllerTest {

	@SuppressWarnings("deprecation")
	@Test
	void getProductById() {
		Product result;
		MyController ctrl;
		ctrl = new MyController();
		result = ctrl.getProductById(1L);
		Assert.isTrue(null != result);
	}

}
