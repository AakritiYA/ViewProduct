//package com.springrest.demo.dao;
//
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import org.springframework.stereotype.Repository;
//import com.springrest.demo.entities.Product;
//import com.springrest.demo.util.DBUtility;
//
//@Repository
//public class ProductDaoImpl implements ProductDao {
//	
//    @PersistenceContext
//    private EntityManager entityManager;
//    
//    @Override
//    public Product getProductById(Long id) {
//    	EntityManager entityManager= DBUtility.getEntityManager();
//        return entityManager.find(Product.class, id);
//    }
//
//    @Override
//    public List<Product> getProducts() {
//    	EntityManager entityManager = DBUtility.getEntityManager();
//        TypedQuery<Product> query = entityManager.createQuery("SELECT o FROM " + Product.class.getSimpleName() + " o",
//                Product.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public void save(Product product) {
//    	EntityManager entityManager = DBUtility.getEntityManager();
//	    entityManager.getTransaction().begin();
//		entityManager.persist(product);
//		entityManager.getTransaction().commit();
//       
//    }
//
////    @Override
////    public Product getProductById(Long id) {
////        EntityManager entityManager = DBUtility.getEntityManager();
////        return entityManager.find(Product.class, id);
////    }
////
////    @Override
////    public List<Product> getProducts() {
////        EntityManager entityManager = DBUtility.getEntityManager();
////        TypedQuery<Product> query = entityManager.createQuery("SELECT o FROM " + Product.class.getSimpleName() + " o",
////                Product.class);
////        return query.getResultList();
////    }
////
////    @Override
////    public void save(Product product) {
////        EntityManager entityManager = DBUtility.getEntityManager();
////        entityManager.getTransaction().begin();
////        entityManager.persist(product);
////        entityManager.getTransaction().commit();
////    }
//}
