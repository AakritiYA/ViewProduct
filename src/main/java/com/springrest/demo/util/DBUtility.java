package com.springrest.demo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class DBUtility {

	private static EntityManagerFactory entityManageFactory;
	
		public final static EntityManager getEntityManager() {
			EntityManager entityManager;
			if (null == DBUtility.entityManageFactory) {
				DBUtility.buildEntityManagerFactory();
			}
			if (DBUtility.entityManageFactory.isOpen()) {
				entityManager = DBUtility.entityManageFactory.createEntityManager();
			} else {
				DBUtility.buildEntityManagerFactory();
				entityManager = DBUtility.entityManageFactory.createEntityManager();
			}
			
			try {
				entityManager.createNativeQuery("Select 1").getResultList().iterator().next();
			} catch (Throwable error) {
				DBUtility.closeEntityManagerFactory();
				DBUtility.buildEntityManagerFactory();
				entityManager = DBUtility.entityManageFactory.createEntityManager();
			}
			return entityManager;
		}
		
		public final static void closeEntityManagerFactory() {
			if (null != DBUtility.entityManageFactory) {
				DBUtility.entityManageFactory.close();
				DBUtility.entityManageFactory = null;
			}
		}
		
		private final static void buildEntityManagerFactory() {
			try {
				DBUtility.entityManageFactory = Persistence.createEntityManagerFactory("product");
			} catch (Throwable error) {
				throw new ExceptionInInitializerError(error);
			}
		}
}
