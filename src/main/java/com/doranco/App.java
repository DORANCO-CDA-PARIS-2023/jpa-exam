package com.doranco;


import com.doranco.cli.HotelCli;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App
{
    public static void main( String[] args )
    {
        try (EntityManagerFactory ef = Persistence.createEntityManagerFactory("TpFinal")){
        	HotelCli hotelCli = new HotelCli(ef);
        	hotelCli.start();
        }
    }
}
