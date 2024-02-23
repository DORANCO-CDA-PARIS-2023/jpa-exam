package com.doranco.service;

import com.doranco.entity.Hotel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HotelService {
    private EntityManager entityManager;

    public HotelService() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HotelPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void ajouterHotel(String nom, String adresse, int nbChambresDisponibles) {
        entityManager.getTransaction().begin();
        Hotel hotel = new Hotel(nom, adresse, nbChambresDisponibles);
        entityManager.persist(hotel);
        entityManager.getTransaction().commit();
    }

    public void close() {
        entityManager.close();
    }

    public static void main(String[] args) {
        HotelService hotelService = new HotelService();
        hotelService.ajouterHotel("Hotel Test", "Adresse Test", 50);
        hotelService.close();
    }
}
