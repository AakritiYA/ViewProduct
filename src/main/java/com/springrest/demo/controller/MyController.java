package com.springrest.demo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.demo.entities.Product;
import com.springrest.demo.util.DBUtility;

@RestController
public class MyController {
	
    @GetMapping("products")
    public List<Product> getAllProducts() {
    	EntityManager entityManager = DBUtility.getEntityManager();
        TypedQuery<Product> query = entityManager.createQuery("SELECT o FROM " + Product.class.getSimpleName() + " o",
                Product.class);
        return query.getResultList();
    }
    
      @GetMapping("/products/title/category_name")
      public Product getProductByTitleAndCategoryId(
            @RequestParam("title") String title,
            @RequestParam("category_name") String level1) {
        EntityManager entityManager = DBUtility.getEntityManager();
        String query = "SELECT * FROM product " +
                "JOIN category ON product.category_id = category.id " +
                "WHERE title = :title AND level1 = :category_name;";

        TypedQuery<Product> typedQuery = entityManager.createQuery(query, Product.class);
        typedQuery.setParameter("title", title);
        typedQuery.setParameter("category_name", level1);
        return typedQuery.getSingleResult();
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable Long id) {
    	EntityManager entityManager= DBUtility.getEntityManager();
        return entityManager.find(Product.class, id);
    }

	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
	    EntityManager entityManager = null;
	    EntityTransaction transaction = null;
	    try {
	        entityManager = DBUtility.getEntityManager();
	        transaction = entityManager.getTransaction();
	        transaction.begin();
	        entityManager.persist(product);
	        transaction.commit();
	    } catch (RollbackException e) {
	    	if (transaction != null && transaction.isActive()) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (entityManager != null && entityManager.isOpen()) {
	            entityManager.close();
	        }
	    }
	    return product;
	}
	
}
