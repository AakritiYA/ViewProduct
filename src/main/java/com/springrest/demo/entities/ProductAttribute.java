package com.springrest.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attribute")
public class ProductAttribute {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long attributeid;
	 
	 @ManyToOne
	 private Product product;

	 private String color;
	 private String size;
	 
	 public ProductAttribute(String size, String color) {
	        super();
	        this.setSize(size);
	        this.setColor(color);
	    }

	

	public ProductAttribute() {
		 super();
	 }
	 
	 public Long getAttributeid() {
		return attributeid;
	}

	public void setAttributeid(Long attributeid) {
		this.attributeid = attributeid;
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
		return "ProductAttribute [attributeid=" + attributeid + ", color=" + color + ", size=" + size + "]";
		}
	 
	 public void setProduct(Product product) {
	        this.product = product;
	    }

	    public Product getProduct() {
	        return product;
	    }
}
