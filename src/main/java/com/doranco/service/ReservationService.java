package com.doranco.service;


import com.doranco.entities.Reservation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ReservationService  {
    private final EntityManager manager;

    public ReservationService(EntityManager manager)
    {
        this.manager = manager;
    }



    public void create(Reservation reservation)
    {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(reservation);
        transaction.commit();
    }

    public List<Reservation> findAll()
    {
        return manager
                .createQuery( "SELECT l FROM Reservation l", Reservation.class)
                .getResultList();
    }
}

