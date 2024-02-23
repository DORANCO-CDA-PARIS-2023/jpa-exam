package com.doranco.service;

import com.doranco.entity.Chambre;
import com.doranco.entity.Hotel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ChambreService {
    private EntityManager entityManager;

    public ChambreService() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TpFinal");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void ajouterChambre(String numero, String type, double prixParNuit, Hotel hotel) {
        entityManager.getTransaction().begin();
        Chambre chambre = new Chambre(numero, type, prixParNuit, hotel);
        entityManager.persist(chambre);
        entityManager.getTransaction().commit();
    }

    public void close() {
        entityManager.close();
    }
}
