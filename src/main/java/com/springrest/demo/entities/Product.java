package com.springrest.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private double price;

    @Column
    private String description;

    @OneToMany(mappedBy = "product")
    private List<ProductAttribute> attributes;

    private Product(String title, double price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.attributes = new ArrayList<>();
    }

    public Long getId() {
        return id;
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

    public List<ProductAttribute> getAttributes() {
        return attributes;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", title=" + title + ", price=" + price + ", description=" + description + "]";
    }
}
