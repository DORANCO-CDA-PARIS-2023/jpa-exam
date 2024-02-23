package com.doranco.service;

import java.util.List;

import com.doranco.entity.Client;
import com.doranco.entity.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ClientService {
    private final EntityManager manager;

    public ClientService(EntityManager manager)
    {
        this.manager = manager;
    }
    
    public void create(Client client)
    {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(client);
        transaction.commit();
    }
    
    public List<Client> findAll()
    {
        return manager
                .createQuery( "SELECT c FROM Client c", Client.class)
                .getResultList();
    }
    
    public void remove(int id) {
        EntityTransaction transaction = manager.getTransaction();
        Client client = manager.find(Client.class, id);
        transaction.begin();
        manager.remove(client);
        transaction.commit();
    }
    
    public Client findById(int id) {
    	return manager.find(Client.class, id);
    }

}
