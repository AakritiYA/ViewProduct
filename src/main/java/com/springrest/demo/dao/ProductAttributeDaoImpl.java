//package com.springrest.demo.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//
//import org.springframework.stereotype.Repository;
//
//import com.springrest.demo.entities.ProductAttribute;
//import com.springrest.demo.util.DBUtility;
//
//
//@Repository
//public class ProductAttributeDaoImpl implements ProductAttributeDao {
//
//    @PersistenceContext(unitName = "product")
//    private EntityManager entityManager;
//
//    @Override
//    public ProductAttribute getProductAttributeById(long id) {
//    	EntityManager entityManager = DBUtility.getEntityManager();
//		
//		return entityManager.find(ProductAttribute.class, id);	
//		
////        return entityManager.find(ProductAttribute.class, id);
//    }
//    
//    @Override
//    public void add(ProductAttribute productAttribute) {
//    	EntityManager entityManager = DBUtility.getEntityManager();
//    	entityManager.getTransaction().begin();
//    	entityManager.persist(productAttribute);
//    	entityManager.getTransaction().commit();
//        entityManager.getTransaction().begin();
//        entityManager.persist(productAttribute);
//        entityManager.getTransaction().commit();
//    }
//    
//    @Override
//    public List<ProductAttribute> getAll() {
//        
//    	EntityManager entityManager = DBUtility.getEntityManager();
//		TypedQuery<ProductAttribute> query = entityManager.createQuery("SELECT t from "+ ProductAttribute.class.getSimpleName() +" t",ProductAttribute.class);
//		return query.getResultList();
//    }
//}
