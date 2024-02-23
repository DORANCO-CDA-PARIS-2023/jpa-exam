package com.doranco.service;

import java.util.List;

import com.doranco.entity.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class HotelService {
	
    private final EntityManager manager;

    public HotelService(EntityManager manager)
    {
        this.manager = manager;
    }
    
    public void create(Hotel hotel)
    {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(hotel);
        transaction.commit();
    }
    
    public List<Hotel> findAll()
    {
        return manager
                .createQuery( "SELECT h FROM Hotel h", Hotel.class)
                .getResultList();
    }
    
    public void remove(int id) {
        EntityTransaction transaction = manager.getTransaction();
        Hotel hotel = manager.find(Hotel.class, id);
        transaction.begin();
        manager.remove(hotel);
        transaction.commit();
    }
    
    public Hotel findById(int id) {
    	return manager.find(Hotel.class, id);
    }

}
