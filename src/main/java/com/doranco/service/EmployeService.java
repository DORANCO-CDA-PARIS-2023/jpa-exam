package com.doranco.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.doranco.entity.Employe;
import com.doranco.entity.Hotel;

public class EmployeService {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EmployeService() {
        emf = Persistence.createEntityManagerFactory("TpFinal");
        em = emf.createEntityManager();
    }

    public void ajouterEmploye(String prenom, String nom, String poste, int idHotel) {
        em.getTransaction().begin();

        Employe employee = new Employe();
        employee.setPrenom(prenom);
        employee.setNom(nom);
        employee.setPoste(poste);

        Hotel hotel = em.find(Hotel.class, idHotel);
        employee.setHotel(hotel);

        em.persist(employee);

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