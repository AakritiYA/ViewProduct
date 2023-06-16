//package com.springrest.demo.services;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.springrest.demo.dao.ProductDao;
//import com.springrest.demo.entities.Product;
//
//
//@Service
//public class ProductServiceImpl implements ProductService {
//
//    @Autowired
//    private ProductDao productDao;
//
//    @Override
//    public List<Product> getAllProduct() {
//        return productDao.getProducts();
//    }
//
//    @Override
//    public Product getProductById(Long productId) {
//        return productDao.getProductById(productId);
//    }
//
//    @Override
//    public Product addProduct(Product product) {
//        productDao.save(product);
//        return product;
//    }
//}
