package com.doranco.main;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import com.doranco.service.HotelService;
import com.doranco.entity.Hotel;
import com.doranco.service.ChambreService;
import com.doranco.service.EmployeService;

public class App
{
	public static void main(String[] args) {
        try (EntityManagerFactory ef = Persistence.createEntityManagerFactory("TpFinal")) {
            testGestionHotels();
            testGestionChambres();
            testGestionEmployes();

        }
    }

    private static void testGestionHotels() {
        HotelService hotelService = new HotelService();
        hotelService.quitter();
    }

    private static void testGestionChambres() {
        ChambreService chambreService = new ChambreService();
        HotelService hotelService = new HotelService();
        
        Hotel hotel = hotelService.getHotelById(1);

        chambreService.ajouterChambre(hotel, 101, "Simple", 100.0);
        hotelService.quitter();
    }
    
    private static void testGestionEmployes() {
        EmployeService employeeService = new EmployeService();
        HotelService hotelService = new HotelService();

        Hotel hotel = hotelService.getHotelById(1);

        employeeService.ajouterEmploye("John", "Doe", "Receptionist", hotel.getIdHotel());

        hotelService.quitter();
        employeeService.quitter();
    }
}
