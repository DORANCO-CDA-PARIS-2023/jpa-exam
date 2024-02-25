package com.doranco.service.gestions;

import java.util.List;
import java.util.Scanner;

import com.doranco.dao.*;
import com.doranco.entity.Hotel;
import com.doranco.entity.uers.Address;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GestionaireHotel {

    private final Scanner scanner;
    private final HotelDao hotelDao;
    private AddressDao adresseDao;
    

	public GestionaireHotel() {
		this.scanner = new Scanner(System.in);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hotel");
		EntityManager manager = factory.createEntityManager();
		this.hotelDao = new HotelDao(manager);
		this.adresseDao = new AddressDao(manager);
	}
	
	
    public void addHotel() throws Exception {
        System.out.print("Enter Hotel Name: ");
        String name = scanner.next(); // Consume newline character

        System.out.print("Enter Hotel Téléphone: ");
        String telephone = scanner.next(); // Consume newline character

        System.out.print("Enter Hotel Email: ");
        String email = scanner.next();

        Address address = createAddress();
        Hotel hotel = new Hotel(name, telephone, email, address);

        hotelDao.addHotel(hotel);
        System.out.println("Hotel added successfully");
    }

    public Address createAddress() throws Exception {
        System.out.println(" ======= Enter Address: ============ ");
        System.out.print("Enter Number: ");
        String number = scanner.next();
        System.out.print("Enter Street: ");
        String street = scanner.next();
        System.out.print("Enter City: ");
        String city = scanner.next();
        System.out.print("Enter ZipCode: ");
        String zipCode = scanner.next();
        System.out.print("Enter Country: ");
        String country = scanner.next();

        Address address = new Address(number, street, city, zipCode, country);
        adresseDao.addAddress(address);
        
        System.out.println("Address added successfully");

        return address;
    }



    public void displayHotels() {
        try {
            List<Hotel> hotels = hotelDao.getHotels();
            System.out.println("Hotels disponible: ");
            hotels.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getHotelById() throws Exception {
        System.out.print("Enter Hotel ID: ");
        Long id = scanner.nextLong();
        Hotel hotel = hotelDao.getHotelById(id);
        System.out.println(hotel);
    }
    

    public Hotel getHotelById(Long id) throws Exception {
        System.out.print("Enter Hotel ID: ");
        Hotel hotel = hotelDao.getHotelById(id);
        System.out.println(hotel);
		return hotel;
    }

    public void updateHotel() throws Exception {
        System.out.print("Enter Hotel ID: ");
        Long id = scanner.nextLong();
        Hotel hotel = hotelDao.getHotelById(id);
        System.out.print("Enter Hotel Name: ");
        hotel.setName(scanner.next());
        System.out.print("Enter Hotel Téléphone: ");
        hotel.setPhone(scanner.next());
        System.out.print("Enter Hotel Email: ");
        hotel.setEmail(scanner.next());
        hotelDao.updateHotel(hotel);
        System.out.println("Hotel updated successfully");
        
    }

    public void deleteHotel() throws Exception {
		System.out.print("Enter Hotel ID: ");
		Long id = scanner.nextLong();
		hotelDao.removeHotel(id);
		System.out.println("Hotel deleted successfully");
    }


    
    

    
    
    
    
}

