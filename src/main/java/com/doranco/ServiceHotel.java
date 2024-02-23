package com.doranco;

import com.doranco.entity.Hotel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class ServiceHotel {

    private final EntityManager manager;

    public ServiceHotel(EntityManager manager) {this.manager = manager;}

    public void create(Hotel hotel) {
        EntityTranction transactionction = manager.getTransaction();
        transactionctionction.begin();
        manager.persist(hotel);
        transactionction.commit();

    }

    public List<Hotel> findAll(){
        return manager
                .createQuery("");
    }




}



