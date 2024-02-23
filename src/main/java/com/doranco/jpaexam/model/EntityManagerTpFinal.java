package com.doranco.jpaexam.model;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public final class EntityManagerTpFinal {

    private static EntityManagerTpFinal INSTANCE;

    private final EntityManagerFactory emf;

    private EntityManagerTpFinal() throws PersistenceException {
        this.emf = Persistence.createEntityManagerFactory("TpFinal");
    }

    public static EntityManagerTpFinal getINSTANCE() throws PersistenceException {
        if (INSTANCE == null) {
            INSTANCE = new EntityManagerTpFinal();
        }
        return INSTANCE;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return this.emf;
    }

    public void closeEntityManagerFactory() {
        this.emf.close();
        INSTANCE = null;
    }
}
