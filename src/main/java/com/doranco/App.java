package com.doranco;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App
{
    public static void main( String[] args )
    {
        try (EntityManagerFactory ef = Persistence.createEntityManagerFactory("TpFinal")){

        }
    }
}
