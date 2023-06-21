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
import org.springframework.web.bind.annotation.RestController;
import com.springrest.demo.entities.Product;
import com.springrest.demo.util.DBUtility;

@RestController
public class MyController {

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		EntityManager entityManager = null;
		List<Product> productList = null;
		try {
			entityManager = DBUtility.getEntityManager();
			TypedQuery<Product> query = entityManager
					.createQuery("SELECT o FROM " + Product.class.getSimpleName() + " o", Product.class);
			productList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (entityManager != null && entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return productList;
	}

	@GetMapping("/products/{level1}/{level2}")
	public Product getProductByTitleAndCategoryId(@PathVariable("level1") String level1,
			@PathVariable("level2") String level2) {
		EntityManager entityManager = DBUtility.getEntityManager();
		String query1 = "SELECT * FROM product " + "JOIN category ON product.category_id = category.id "
				+ "WHERE level1 = :level1 AND level2 = :level2;";
		TypedQuery<Product> typedQuery = entityManager.createQuery(query1, Product.class);
		typedQuery.setParameter("level1", level1);
		typedQuery.setParameter("level2", level2);
		return typedQuery.getSingleResult();
	}

	@GetMapping("/products/{productId}")
	public Product getProductById(@PathVariable("productId") Long productId) {
		EntityManager entityManager = null;
		 Product product = null;
		try {
			entityManager = DBUtility.getEntityManager();
			product = entityManager.find(Product.class, productId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (entityManager != null && entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return product;
	}

	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		Product result = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = DBUtility.getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(product);
			transaction.commit();
			result = product;
		} catch (RollbackException e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (entityManager != null && entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return result;
	}

}
