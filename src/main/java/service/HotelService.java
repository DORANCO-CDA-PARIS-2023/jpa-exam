package service;

import java.util.List;

import entity.Hotel;
import jakarta.persistence.EntityManager;

import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

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
    }

    public List<Hotel> findByName(String name)
    {
        Query query = manager.createQuery("SELECT l FROM Hotel l WHERE l.name = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }
}
