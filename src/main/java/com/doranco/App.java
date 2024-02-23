package com.doranco;


import com.doranco.cli.HotelManagementCLI;

import com.doranco.service.CustomerService;
import com.doranco.service.HotelService;
import com.doranco.service.ReservationService;
import com.doranco.service.RoomService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.var;

import java.text.ParseException;

public class App
{
    public static void main( String[] args )
    {
        try (EntityManagerFactory ef = Persistence.createEntityManagerFactory("TpFinal")){
            var manager = ef.createEntityManager();
        CustomerService customerService = new CustomerService(manager);
        HotelService hotelService = new HotelService(manager); // Initialize with your implementation
        ReservationService reservationService = new ReservationService(manager); // Initialize with your implementation
        RoomService roomService=new RoomService(manager);
        HotelManagementCLI cli = new HotelManagementCLI(hotelService, reservationService,customerService,roomService);
        cli.start();
    } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
