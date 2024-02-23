package com.doranco.service;

import com.doranco.entities.Room;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class RoomService {private final EntityManager manager;

    public RoomService(EntityManager manager)
    {
        this.manager = manager;
    }



    public void create(Room room)
    {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(room);
        transaction.commit();
    }

    public List<Room> findAll()
    {
        return manager
                .createQuery( "SELECT l FROM Room l", Room.class)
                .getResultList();
    }}


