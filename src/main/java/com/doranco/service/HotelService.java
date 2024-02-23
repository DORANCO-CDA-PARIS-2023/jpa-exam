package com.doranco.service;

import com.doranco.entity.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class HotelService {
    
    private final EntityManager manager;

    public HotelService(EntityManager manager) {
        this.manager = manager;
    }
    
    public void addHotel(Hotel hotel) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(hotel);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
