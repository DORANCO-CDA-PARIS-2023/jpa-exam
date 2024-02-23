package main.java.com.doranco.model;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public final class EntityManagerHotel{

    private static EntityManagerHotel INSTANCE;

    private final EntityManagerFactory emf;

    private EntityManagerHotel() throws PersistenceException {
        this.emf = Persistence.createEntityManagerFactory("Hotel");
    }

    public static EntityManagerHotel getINSTANCE() throws PersistenceException {
        if (INSTANCE == null) {
            INSTANCE = new EntityManagerHotel();
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