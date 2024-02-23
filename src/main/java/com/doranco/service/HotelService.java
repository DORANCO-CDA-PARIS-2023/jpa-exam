package com.doranco.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.doranco.entity.Hotel;

public class HotelService {

    private EntityManagerFactory emf;
    private EntityManager em;

    public HotelService() {
        emf = Persistence.createEntityManagerFactory("TpFinal");
        em = emf.createEntityManager();
    }
    
    public Hotel getHotelById(int idHotel) {
        return em.find(Hotel.class, idHotel);
    }

    public void ajouterHotel(String nom, String adresse, int nbChambres) {
        em.getTransaction().begin();

        Hotel hotel = new Hotel();
        hotel.setNom(nom);
        hotel.setAdresse(adresse);
        hotel.setNbChambre(nbChambres);

        em.persist(hotel);

        em.getTransaction().commit();
    }

    public void quitter() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }
}