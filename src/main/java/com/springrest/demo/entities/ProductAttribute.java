package com.springrest.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductAttribute {

	 @Id
	 private long id;
	 private String color;
	 private String size;
	 
	 @ManyToOne
	 @JoinColumn(name = "Product_Id")
	 private Product product;
	 
	 public ProductAttribute(long id, String color, String size, Product product) {
	        super();
	        this.id = id;
	        this.color = color;
	        this.size = size;
	    }

	 public ProductAttribute() {
		 super();
	 }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}


	@Override
	public String toString() {
		return "ProductAttribute [id=" + id + ", color=" + color + ", size=" + size + "]";
	}
	 
	 
}
