package com.doranco.DAO;

import java.sql.SQLException;
import java.util.List;
import com.doranco.entity.Service_proposed;
import com.doranco.utils.Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class ServicedProposedDAO implements IServiceProposedDAO {

	@Override
	public <Service_proposed> Service_proposed find(int id, Class<Service_proposed> service_proposed) throws SQLException {
		EntityManager em = Utils.getEntityManagerFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	    transaction.begin();
	    Service_proposed typeReturned = em.find(service_proposed, id);
	    transaction.commit();
	    em.close();
	    return typeReturned;
	}

	@Override
	public <Service_proposed> List<Service_proposed> findAll(Class<Service_proposed> service_proposed) throws SQLException {
EntityManager em = Utils.getEntityManagerFactory().createEntityManager();
	    
	    
	    String jpql = "SELECT l FROM Livre l";
	    TypedQuery<Service_proposed> query = em.createQuery(jpql, service_proposed);
	    
	   
	    List<Service_proposed> services = query.getResultList();
	    
	    em.close();
	    
	    return services;
	}

	@Override
	public <Service_proposed> void create(Service_proposed service_proposed) throws SQLException {
EntityManager em = Utils.getEntityManagerFactory().createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		em.persist(service_proposed);
		
		
		transaction.commit();
		
		em.close();
		
	}

	@Override
	public void delete(int id, Class<?> service_proposed) throws SQLException {
EntityManager em = Utils.getEntityManagerFactory().createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		 
		Service_proposed service_proposed_to_delete = em.find(Service_proposed.class, id);
	    
	    if (service_proposed_to_delete != null) {
	        em.remove(service_proposed_to_delete);
	    }
		transaction.commit();
		
		em.close();
		
	}
	@Override
	public <Service_proposed> Service_proposed update(int id, Service_proposed service_proposed) throws SQLException {
		EntityManager em = Utils.getEntityManagerFactory().createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	    transaction.begin();
	    Service_proposed existingEntity = (Service_proposed) em.find(service_proposed.getClass(), id);
	    if (existingEntity != null) {
	    	service_proposed = (Service_proposed) em.merge(service_proposed);
	    }
	    transaction.commit();
	    em.close();
	    return service_proposed;
	}


}
