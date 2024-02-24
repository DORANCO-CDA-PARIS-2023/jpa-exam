package com.doranco.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.doranco.dao.*;
import com.doranco.entity.Hotel;
import com.doranco.entity.uers.Address;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CommandLineOlde2 {

    private final Scanner sc;
    private final HotelDao hotelDao;
    private final CategorieChambreDao categorieChambreDao;
    private final ChambreDao chambreDao;
    private final UserDao utilisateurDao;
    private final ClientDao clientDao;
    private final ModerateurDao moderateurDao;
    private final ReservationDao reservationDao;
    private final FactureDao factureDao;
    private final AddressDao adresseDao;

    private final EntityManagerFactory ef = Persistence.createEntityManagerFactory("TpFinal");
    private final EntityManager manager = ef.createEntityManager();

    public CommandLineOlde2() throws SQLException {
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

    private void printOptions(String options) {
        System.out.print(options);
    }

    private void printMainOption() {
        printOptions("""
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

    private void printSubMenu(String options) {
        printOptions(options);
    }

    public void start() throws Exception {
        int cmd;
        do {
            printMainOption();
            cmd = sc.nextInt();

            switch (cmd) {
                case 1 -> handleHotelOptions();
                case 2 -> printSubMenu("""
                        Option :
                             1 - Add Categorie Chambre
                             2 - Display Categorie Chambre
                             3 - Update Categorie Chambre
                             4 - Delete Categorie Chambre
                             5 - Retour
                         > """);
                case 3 -> printSubMenu("""
                        Option :
                             1 - Add Chambre
                             2 - Display Chambre
                             3 - Update Chambre
                             4 - Delete Chambre
                             5 - Retour
                         > """);
                case 4 -> printSubMenu("""
                        Option :
                             1 - Add Utilisateur
                             2 - Display Utilisateur
                             3 - Update Utilisateur
                             4 - Delete Utilisateur
                             5 - Retour
                         > """);
                case 5 -> printSubMenu("""
                        Option :
                             1 - Add Client
                             2 - Display Client
                             3 - Update Client
                             4 - Delete Client
                             5 - Retour
                         > """);
                case 6 -> printSubMenu("""
                        Option :
                             1 - Add Moderateur
                             2 - Display Moderateur
                             3 - Update Moderateur
                             4 - Delete Moderateur
                             5 - Retour
                         > """);
                case 7 -> printSubMenu("""
                        Option :
                             1 - Add Reservation
                             2 - Display Reservation
                             3 - Update Reservation
                             4 - Delete Reservation
                             5 - Retour
                         > """);
                case 8 -> printSubMenu("""
                        Option :
                             1 - Add Facture
                             2 - Display Facture
                             3 - Update Facture
                             4 - Delete Facture
                             5 - Retour
                         > """);
                case 9 -> printSubMenu("""
                        Option :
                             1 - Add Address
                             2 - Display Address
                             3 - Update Address
                             4 - Delete Address
                             5 - Retour
                         > """);
                case 10 -> System.out.println("Application closed");
                default -> System.out.println("Invalid option");
            }
        } while (cmd != 10);
        sc.close();
    }

//    private void handleHotelOptions() throws Exception {
//        int cmd;
//        do {
//        	printMainOption();
//            cmd = sc.nextInt();
//
//            switch (cmd) {
//                case 1 -> addHotel();
//                case 2 -> printCategorieChambreOption();
//                case 3 -> printChambreOption();
//                case 4 -> printUtilisateurOption();
//                case 5 -> printClientOption();
//                case 6 -> printModerateurOption();
//                case 7 -> printReservationOption();
//                case 8 -> printFactureOption();
//                case 9 -> printAddressOption();
//                default -> System.out.println("Invalid option");
//            }
//        } while (cmd != 5);
//    }
    
    private void handleHotelOptions() throws Exception {
        int cmd;
        do {
        	printMainOption();
            cmd = sc.nextInt();

            switch (cmd) {
                case 1 -> createHotel();
                case 2 -> getHotelById();
                case 3 -> displayHotels();
                case 4 -> updateHotel();
                case 5 -> deleteHotel();
                default -> System.out.println("Invalid option");
            }
        } while (cmd != 6);
		sc.close();
		System.out.println("Application closed");
    }
    
	private void createHotel() throws Exception {
        System.out.print("Enter Hotel Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Hotel Phone : ");
        String phone = sc.nextLine();
        System.out.print("Enter Hotel Email : ");
        String email = sc.nextLine();
        System.out.print("Enter Hotel Address : ");

        System.out.print("Enter Number : ");
        String number = sc.nextLine();
        System.out.print("Enter Street : ");
        String street = sc.nextLine();
        System.out.print("Enter City : ");
        String city = sc.nextLine();
        System.out.print("Enter ZipCode : ");
        String zipCode = sc.nextLine();
        System.out.print("Enter Country : ");
        String country = sc.nextLine();
        Address address = new Address(number, street, city, zipCode, country);
        adresseDao.addAddress(address);

        Hotel hotel = new Hotel(name, phone, email, address);
        hotelDao.addHotel(hotel);
        System.out.println("Hotel added successfully");
    }
	
	private Hotel getHotelById() throws Exception {
		System.out.print("Enter Hotel ID : ");
        Long id = sc.nextLong();
        return hotelDao.getHotelById(id);
    }

    private Object printAddressOption() {
        // TODO Auto-generated method stub
        return null;
    }

    private Object printFactureOption() {
        // TODO Auto-generated method stub
        return null;
    }

    private Object printReservationOption() {
        // TODO Auto-generated method stub
        return null;
    }

    private Object printModerateurOption() {
        // TODO Auto-generated method stub
        return null;
    }

    private Object printClientOption() {
        // TODO Auto-generated method stub
        return null;
    }

    private Object printUtilisateurOption() {
        // TODO Auto-generated method stub
        return null;
    }

    private Object printChambreOption() {
        // TODO Auto-generated method stub
        return null;
    }

    private Object printCategorieChambreOption() {
        // TODO Auto-generated method stub
        return null;
    }

    private Object deleteHotel() {
        // TODO Auto-generated method stub
        return null;
    }

    private Object updateHotel() {
        // TODO Auto-generated method stub
        return null;
    }

    private List<Hotel> displayHotels() throws Exception {
        try {
			return hotelDao.getHotels();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
        
    }
	

    



	



}
