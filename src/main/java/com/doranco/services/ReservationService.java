package com.doranco.services;

import com.doranco.entity.Chambre;
import com.doranco.entity.Client;
import com.doranco.entity.Reservation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class ReservationService {

    private static EntityManager manager;

    public ReservationService(EntityManager manager){this.manager = manager;}

    public void create (Reservation reservation)
    {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(reservation);
        transaction.commit();
    }

    public void delete (int id)
    {

    }

    public static List<Reservation> findAll()
    {
        return manager
                .createQuery("SELECT r FROM Reservation r", Reservation.class)
                .getResultList();
    }

    public List<Reservation> findByRoom(Chambre chambre)
    {
        Query query = manager.createQuery("SELECT r FROM Reservation r WHERE r.chambre = :chambre");
        query.setParameter("chambre", chambre);
        return query.getResultList();
    }

    public List<Reservation> findByCustomer(Client client)
    {
        Query query = manager.createQuery("SELECT r FROM Reservation r WHERE r.client = :client");
        query.setParameter("client", client);
        return query.getResultList();
    }
}
