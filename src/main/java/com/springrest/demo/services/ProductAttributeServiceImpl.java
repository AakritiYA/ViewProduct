package com.springrest.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.demo.dao.ProductAttributeDao;
import com.springrest.demo.entities.ProductAttribute;

@Service
public class ProductAttributeServiceImpl implements ProductAttributeService{

    @Autowired
    private ProductAttributeDao productAttributeDao;

    @Override
    public ProductAttribute getProductAttributeById(long id) {
        return productAttributeDao.getProductAttributeById(id);
    }

    @Override
    public void addProductAttribute(ProductAttribute productAttribute) {
        productAttributeDao.add(productAttribute);
    }

    @Override
    public List<ProductAttribute> getAllProductAttributes() {
        return productAttributeDao.getAll();
    }
}
