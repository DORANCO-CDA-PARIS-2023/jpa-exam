package com.doranco.main;

import entity.Chambre;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TpFinal");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Chambre chambre = new Chambre();
        chambre.setNumber(101);
        chambre.setType("simple");
        chambre.setPrix(100);
        chambre.setDisponible(true);

        entityManager.persist(chambre);

        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}
