package com.doranco.service;

import java.util.List;

import com.doranco.entity.Client;
import com.doranco.entity.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ServiceService {
    private final EntityManager manager;

    public ServiceService(EntityManager manager)
    {
        this.manager = manager;
    }
    
    public void create(Service service)
    {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(service);
        transaction.commit();
    }
    
    public List<Service> findAll()
    {
        return manager
                .createQuery( "Client c FROM Client c", Service.class)
                .getResultList();
    }
    
    public void remove(int id) {
        EntityTransaction transaction = manager.getTransaction();
        Service service = manager.find(Service.class, id);
        transaction.begin();
        manager.remove(service);
        transaction.commit();
    }
    
    public Service findById(int id) {
    	return manager.find(Service.class, id);
    }
}
