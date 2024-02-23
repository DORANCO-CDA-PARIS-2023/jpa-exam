package com.doranco.service;

import java.util.List;

import com.doranco.entity.Hotel;
import com.doranco.entity.Room;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RoomService {

    private final EntityManager manager;

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
                .createQuery( "SELECT r FROM Room r", Room.class)
                .getResultList();
    }
    
    public void remove(int id) {
        EntityTransaction transaction = manager.getTransaction();
        Room room = manager.find(Room.class, id);
        transaction.begin();
        manager.remove(room);
        transaction.commit();
    }
	
}
