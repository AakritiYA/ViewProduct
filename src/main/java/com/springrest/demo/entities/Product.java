package com.springrest.demo.entities;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Product {

	@Id
	private long id;
	private String title;
	private double price;
	private String description;
	
	@OneToMany(mappedBy = "product")
	private List<ProductAttribute> attribute = new ArrayList<>();;
	
//	public List<ProductAttribute> getAttributes() {
//        return attribute;
//    }
//
//    public void setAttributes(List<ProductAttribute> attributes) {
//        this.attribute = attributes;
//    }
    
//	  public void addAttribute(ProductAttribute attribute) {
//	        attribute.setProduct(this);
//	        attributes.add(attribute);
//	    }
	  
	public void setColor(String color) {
	    if (attribute != null && !attribute.isEmpty()) {
	        attribute.get(attribute.size() - 1).setColor(color);
	    }
	}
	public String getColor() {
//		Console.log("Attribute", attribute);
        if (attribute != null && !attribute.isEmpty()) {
            return attribute.get(0).getColor(); // Assuming color is stored in the first ProductAttribute object in the list
        } 
        else {
            return "gfhgd";
        }
    }
    
    public String getSize() {
        if (attribute != null && !attribute.isEmpty()) {
            return attribute.get(0).getSize(); // Assuming size is stored in the first ProductAttribute object in the list
        } else {
            return "";
        }
    }
    
	public Product(long id, String title, double price, String description) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
	}

	public Product() {
		super();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + ", description=" + description + "]";
	}

	
	
}
