package com.doranco.service;

import com.doranco.entities.Hotel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
                .createQuery( "SELECT l FROM Hotel l", Hotel.class)
                .getResultList();
    }}
