package service;

import java.util.List;


import entity.Room;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

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
                .createQuery( "SELECT l FROM Room l", Room.class)
                .getResultList();
    }

    public List<Room> findByType(String type)
    {
        Query query = manager.createQuery("SELECT l FROM Room l WHERE l.type = :type");
        query.setParameter("type", type);
        return query.getResultList();
    }
}

