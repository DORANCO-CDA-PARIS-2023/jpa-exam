package com.doranco.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import com.doranco.entity.Chambres;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TpFinal");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Chambres chambre = new Chambres();
        chambre.setNumero(1);
        chambre.setType("simple");
        chambre.setPrix(100);
        chambre.setDisponible(true);

        

        entityManager.persist(chambre);

        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}
