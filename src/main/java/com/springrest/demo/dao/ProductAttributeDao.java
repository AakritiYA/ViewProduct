package com.springrest.demo.dao;

import java.util.List;

import com.springrest.demo.entities.ProductAttribute;

public interface ProductAttributeDao {
    ProductAttribute getProductAttributeById(long id);
    void add(ProductAttribute productAttribute);
    List<ProductAttribute> getAll();
}
