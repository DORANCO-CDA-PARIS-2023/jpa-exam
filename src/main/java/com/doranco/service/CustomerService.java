package com.doranco.service;

import com.doranco.entities.Customer;
import com.doranco.entities.Reservation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

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
    }}


