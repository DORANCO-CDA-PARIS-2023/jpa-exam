package com.doranco;


import com.doranco.cli.HotelManagementCLI;

import com.doranco.service.HotelService;
import com.doranco.service.ReservationService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.var;

public class App
{
    public static void main( String[] args )
    {
        try (EntityManagerFactory ef = Persistence.createEntityManagerFactory("TpFinal")){
            var manager = ef.createEntityManager();



        HotelService hotelService = new HotelService(manager); // Initialize with your implementation
        ReservationService reservationService = new ReservationService(); // Initialize with your implementation

        HotelManagementCLI cli = new HotelManagementCLI(hotelService, reservationService);
        cli.start();
    }}
}
