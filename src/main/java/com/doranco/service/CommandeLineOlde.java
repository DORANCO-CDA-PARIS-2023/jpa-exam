package com.doranco.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.doranco.dao.*;
import com.doranco.entity.Hotel;
import com.doranco.entity.uers.Address;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CommandeLineOlde {

	private final Scanner sc;
	private HotelDao hotelDao;
	private CategorieChambreDao categorieChambreDao;
	private ChambreDao chambreDao;
	private UserDao utilisateurDao;
	private ClientDao clientDao;
	private ModerateurDao moderateurDao;
	private ReservationDao reservationDao;
	private FactureDao factureDao;
	private AddressDao adresseDao;

	private EntityManagerFactory ef = Persistence.createEntityManagerFactory("TpFinal");
	private EntityManager manager = ef.createEntityManager();

	public CommandeLineOlde() throws SQLException {
		sc = new Scanner(System.in);
		hotelDao = new HotelDao(manager);
		categorieChambreDao = new CategorieChambreDao(manager);
		chambreDao = new ChambreDao(manager);
		utilisateurDao = new UserDao(manager);
		clientDao = new ClientDao(manager);
		moderateurDao = new ModerateurDao(manager);
		reservationDao = new ReservationDao(manager);
		factureDao = new FactureDao(manager);
		adresseDao = new AddressDao(manager);

	}

	private void printMainOption() {
		System.out.print("""
				Option :
				     1 - Hotel Management
				     2 - Category Chambre Management
				     3 - Chambre Management
				     4 - User Management
				     5 - Client Management
				     6 - Moderateur Management
				     7 - Reservation Management
				     8 - Facture Management
				     9 - Address Management
				     10- Quitter Le Programme
				 > """);

	}

	private void printHotelOption() {
		System.out.print("""
				Option :
				     1 - Add Hotel
				     2 - Display Hotels
				     3 - Update Hotel
				     4 - Delete Hotel
				     5 - Retour
				 > """);
	}

	private void printCategorieChambreOption() {
		System.out.print("""
				Option :
				     1 - Add Categorie Chambre
				     2 - Display Categorie Chambre
				     3 - Update Categorie Chambre
				     4 - Delete Categorie Chambre
				     5 - Retour
				 > """);
	}

	private void printChambreOption() {
		System.out.print("""
				Option :
				     1 - Add Chambre
				     2 - Display Chambre
				     3 - Update Chambre
				     4 - Delete Chambre
				     5 - Retour
				 > """);
	}

	private void printUtilisateurOption() {
		System.out.print("""
				Option :
				     1 - Add Utilisateur
				     2 - Display Utilisateur
				     3 - Update Utilisateur
				     4 - Delete Utilisateur
				     5 - Retour
				 > """);
	}

	private void printClientOption() {
		System.out.print("""
				Option :
				     1 - Add Client
				     2 - Display Client
				     3 - Update Client
				     4 - Delete Client
				     5 - Retour
				 > """);
	}

	private void printModerateurOption() {
		System.out.print("""
				Option :
				     1 - Add Moderateur
				     2 - Display Moderateur
				     3 - Update Moderateur
				     4 - Delete Moderateur
				     5 - Retour
				 > """);
	}

	private void printReservationOption() {
		System.out.print("""
				Option :
				     1 - Add Reservation
				     2 - Display Reservation
				     3 - Update Reservation
				     4 - Delete Reservation
				     5 - Retour
				 > """);
	}

	private void printFactureOption() {
		System.out.print("""
				Option :
				     1 - Add Facture
				     2 - Display Facture
				     3 - Update Facture
				     4 - Delete Facture
				     5 - Retour
				 > """);
	}

	private void printAddressOption() {
		System.out.print("""
				Option :
				     1 - Add Address
				     2 - Display Address
				     3 - Update Address
				     4 - Delete Address
				     5 - Retour
				 > """);
	}

	public void start() throws SQLException {
        int cmd = 0;
        do {
        	printMainOption();
            cmd = sc.nextInt();
            
            if (cmd == 1) {
            	printHotelOption();
            	cmd = sc.nextInt();
            	
        	if (cmd == 1) {
            		addHotel();
            } else if (cmd == 2) {
            	printCategorieChambreOption();
                	
            } else if (cmd == 3) {
            	printChambreOption();
            	
            } else if (cmd == 4) {
            	printUtilisateurOption();
            	
            } else if (cmd == 5) {
            	printClientOption();
            	
            } else if (cmd == 6) {
            	printModerateurOption();
            	
            } else if (cmd == 7) {
            	printReservationOption();
            	
            } else if (cmd == 8) {
            	printFactureOption();
            	
            } else if (cmd == 9) {
            	printAddressOption();
            	
            } else {	
        	System.out.println("Invalid option");
        	start();
            
            }
        } while (cmd != 10) {
		    sc.close();
		    System.out.println("Application closed"); 
        } 
        
	
}

	private void addHotel() throws Exception {
		System.out.print("Enter Hotel Name : ");
		String name = sc.next();
		System.out.print("Enter Hotel Phone : ");
		String phone = sc.next();
		System.out.print("Enter Hotel Email : ");
		String email = sc.next();
		System.out.print("Enter Hotel Address : ");

		System.out.print("Enter Number : ");
		String number = sc.next();
		System.out.print("Enter Street : ");
		String street = sc.next();
		System.out.print("Enter City : ");
		String city = sc.next();
		System.out.print("Enter ZipCode : ");
		String zipCode = sc.next();
		System.out.print("Enter Country : ");
		String country = sc.next();
		Address address = new Address(number, street, city, zipCode, country);
		adresseDao.addAddress(address);

		Hotel hotel = new Hotel(name, phone, email, address);
		hotelDao.addHotel(hotel);
		try {
			hotelDao.addHotel(hotel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}