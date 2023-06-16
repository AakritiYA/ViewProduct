package com.springrest.demo.services;

import java.util.List;

import com.springrest.demo.entities.ProductAttribute;

public interface ProductAttributeService {

    ProductAttribute getProductAttributeById(long id);
    void addProductAttribute(ProductAttribute productAttribute);
    List<ProductAttribute> getAllProductAttributes();
}
