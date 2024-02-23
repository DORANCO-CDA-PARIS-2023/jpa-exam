package com.doranco;


import java.util.List;

import entity.Hotel;
import entity.Room;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import service.HotelService;
import service.RoomService;

public class AppRoom
{
    public static void main( String[] args )
    {
    try (var ef = Persistence.createEntityManagerFactory("finalTP")) {
        var manager = ef.createEntityManager();

        	 RoomService service = new RoomService(manager);

             service.create(new Room("room", 100, 1));
            service.create(new Room("Double Confort.", 300, 3));
             service.create(new Room("Triple Economique", 190, 3));
             service.create(new Room("Triple Economique", 200, 3));

             List<Room> rooms = service.findByType("Triple Economique");
            for (Room room : rooms)
           {
                System.out.println(room);
           }

             manager.close();
         }
     }
 }
     






