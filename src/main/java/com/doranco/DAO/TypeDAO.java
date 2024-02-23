package com.doranco.DAO;

import java.sql.SQLException;
import java.util.List;

import com.doranco.services.ServiceJpa;
import com.doranco.utils.Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;



public class TypeDAO implements ITypeDAO{

	@Override
	public <Type> Type find(int id, Class<Type> type) throws SQLException {
		EntityManager em = Utils.getEntityManagerFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	    transaction.begin();
	    Type typeReturned = em.find(type, id);
	    transaction.commit();
	    em.close();
	    return typeReturned;
	}
		

	@Override
	public <Type> List<Type> findAll(Class<Type> type) throws SQLException {
		EntityManager em = Utils.getEntityManagerFactory().createEntityManager();
	    String jpql = "SELECT e FROM " + type.getSimpleName() + " e";
	    TypedQuery<Type> query = em.createQuery(jpql, type);
	    List<Type> types = query.getResultList();
	    em.close();
	    return types;
	}

	@Override
	public <Type> void create(Type type) throws SQLException {
		EntityManager em = Utils.getEntityManagerFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	    transaction.begin();
	    em.persist(type);
	    transaction.commit();
	    em.close();
		
	}

	@Override
	public void delete(int id, Class<?> type) throws SQLException {
		EntityManager em = Utils.getEntityManagerFactory().createEntityManager();
		 EntityTransaction transaction = em.getTransaction();
		 transaction.begin();
		 Object typeToRemove = em.find(type, id);
		 if (typeToRemove != null) {
		 em.remove(typeToRemove);
		    }
		 transaction.commit();
		 em.close();
		
	}

	@Override
	public <Type> Type update(int id, Type type) throws SQLException {
		EntityManager em = Utils.getEntityManagerFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	    transaction.begin();
	    Type existingEntity = (Type) em.find(type.getClass(), id);
	    if (existingEntity != null) {
	        type = (Type) em.merge(type);
	    }
	    transaction.commit();
	    em.close();
	    return type;
	}

	

}
