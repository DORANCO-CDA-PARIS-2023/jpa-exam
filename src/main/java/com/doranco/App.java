package com.doranco;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        try (EntityManagerFactory ef = Persistence.createEntityManagerFactory("TpFinal")) {

            EntityManager em = ef.createEntityManager();
            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();
        }
    }
}