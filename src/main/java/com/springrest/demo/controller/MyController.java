package com.springrest.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.demo.entities.Product;
import com.springrest.demo.entities.ProductAttribute;
import com.springrest.demo.services.ProductService;

@RestController
public class MyController {

	@Autowired
	private ProductService productService;
	
	//get the products
	@GetMapping("/products")
	public List<Product> getProducts(){
		return this.productService.getProducts();
	}
	
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable String productId) {
		return this.productService.getProduct(Long.parseLong(productId));
	}
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		Product newProduct = new Product(product.getId(), product.getTitle(), product.getPrice(), product.getDescription());
		
        ProductAttribute productAttribute = new ProductAttribute();
        productAttribute.setColor(product.getColor());
        productAttribute.setSize(product.getSize());
//        productAttribute.setProduct(newProduct)
        
        List<ProductAttribute> attributes = new ArrayList<>();
        attributes.add(productAttribute);
//        product.setAttributes(attributes);

		return this.productService.addProduct(newProduct);
	}
	
	
}
