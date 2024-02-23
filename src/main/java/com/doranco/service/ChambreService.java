package com.doranco.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.doranco.entity.Chambre;
import com.doranco.entity.Hotel;

public class ChambreService {

    private EntityManagerFactory emf;
    private EntityManager em;

    public ChambreService() {
        emf = Persistence.createEntityManagerFactory("TpFinal");
        em = emf.createEntityManager();
    }

    public void ajouterChambre(Hotel hotel, int numero, String type, double prix) {
        em.getTransaction().begin();

        Chambre chambre = new Chambre();
        chambre.setHotel(hotel);
        chambre.setNumero(numero);
        chambre.setType(type);
        chambre.setPrix(prix);

        em.persist(chambre);

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
