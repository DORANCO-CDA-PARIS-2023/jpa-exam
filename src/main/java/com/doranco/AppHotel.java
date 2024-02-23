package com.doranco;


import java.util.List;

import entity.Hotel;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import service.HotelService;

public class AppHotel
{
    public static void main( String[] args )
    {
    try (var ef = Persistence.createEntityManagerFactory("finalTP")) {
        var manager = ef.createEntityManager();

        	 HotelService service = new HotelService(manager);

             service.create(new Hotel("super Hotel paris", " 22 rue bapst Paris 75000", 150, true, false,false ));
            service.create(new Hotel("super Hotel madrid", " 2 rue mad madrid 75000", 150, false, false, true));
             service.create(new Hotel("super Hotel milan", " 23 rue mil milan 75000", 150, true, true, true));
             service.create(new Hotel("super Hotel berlin", " 43 rue bb berlin 75000", 150, true, true, true));

             List<Hotel> hotels = service.findByName("super Hotel paris");
             for (Hotel hotel : hotels)
           {
                 System.out.println(hotel);
             }

             manager.close();
         }
     }
 }
     






