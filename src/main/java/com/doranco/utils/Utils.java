package com.doranco.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Utils {
	private static final String PERSISTENCE_UNIT_NAME = "TpFinal";
	private static EntityManagerFactory factory;

    private Utils() {
    }

    public static  EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}
