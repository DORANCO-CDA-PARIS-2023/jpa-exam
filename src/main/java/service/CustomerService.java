package service;

import java.util.List;

import entity.Customer;
import entity.Hotel;
import jakarta.persistence.EntityManager;

import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class CustomerService {

	private final EntityManager manager;

    public CustomerService(EntityManager manager)
    {
        this.manager = manager;
    }

    public void create(Customer customer)
    {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(customer);
        transaction.commit();
    }

    public List<Customer> findAll()
    {
        return manager
                .createQuery( "SELECT l FROM Customer l", Customer.class)
                .getResultList();
    }

    public List<Customer> findByName(String name)
    {
        Query query = manager.createQuery("SELECT l FROM Customer l WHERE l.name = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

	

	public void remove(int customer) {
		EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.remove(customer);
        transaction.commit();
		
	}

	
}
