package com.doranco.services;

import java.sql.SQLException;
import java.util.List;

import com.doranco.utils.Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class ServiceJpa implements IServiceType {

	@Override
	public <T> T find(int id, Class<T> entityClass) throws SQLException {
		EntityManager em = Utils.getEntityManagerFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	    transaction.begin();
	    T entity = em.find(entityClass, id);
	    transaction.commit();
	    em.close();
	    return entity;
	}

	@Override
	public <T> List<T> findAll(Class<T> entityClass) throws SQLException {
		EntityManager em = Utils.getEntityManagerFactory().createEntityManager();
	    String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
	    TypedQuery<T> query = em.createQuery(jpql, entityClass);
	    List<T> entities = query.getResultList();
	    em.close();
	    return entities;
	}

	@Override
	public <T> void create(T entity) throws SQLException {
		EntityManager em = Utils.getEntityManagerFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	    transaction.begin();
	    em.persist(entity);
	    transaction.commit();
	    em.close();
	}

	@Override
	public void delete(int id, Class<?> entityClass) throws SQLException {
		 EntityManager em = Utils.getEntityManagerFactory().createEntityManager();
		 EntityTransaction transaction = em.getTransaction();
		 transaction.begin();
		 Object entity = em.find(entityClass, id);
		 if (entity != null) {
		 em.remove(entity);
		    }
		 transaction.commit();
		 em.close();
	}

	@Override
	public <T> T update(int id, T entity) throws SQLException {
		EntityManager em = Utils.getEntityManagerFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	    transaction.begin();
	    T existingEntity = (T) em.find(entity.getClass(), id);
	    if (existingEntity != null) {
	        entity = (T) em.merge(entity);
	    }
	    transaction.commit();
	    em.close();
	    return entity;
	}
	

}
