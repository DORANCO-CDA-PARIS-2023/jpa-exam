package com.doranco.service;

import java.util.Scanner;

import com.doranco.dao.*;
import com.doranco.entity.uers.Address;
import com.doranco.service.gestions.GestionCategorieChambre;
import com.doranco.service.gestions.GestionChambre;
import com.doranco.service.gestions.GestionClient;
import com.doranco.service.gestions.GestionEmployee;
import com.doranco.service.gestions.GestionReservation;
import com.doranco.service.gestions.GestionaireHotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NewCommandLine {

    private final Scanner scanner;
    private AddressDao adresseDao;
    
    // --------------------
    private GestionaireHotel gestionaireHotel;
    private GestionEmployee gestionEmployee;
    private GestionCategorieChambre gestionCategorieChambre;
    private GestionChambre gestionChambre;
    private GestionClient gestionClient;
    private GestionReservation gestionReservation;

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TpFinal");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public NewCommandLine() {
        scanner = new Scanner(System.in);
        adresseDao = new AddressDao(entityManager);
        
        gestionaireHotel = new GestionaireHotel();
        gestionEmployee = new GestionEmployee();
        gestionCategorieChambre = new GestionCategorieChambre();
        gestionChambre = new GestionChambre();
        gestionClient = new GestionClient();
        gestionReservation = new GestionReservation();
    }

    private void printOptions(String options) {
        System.out.print(options);
    }

    private void printMainOption() {
        printOptions("""
                Main Options:
                 1 - Hotel Management
                 2 - Employee Management
                 3 - Category chambres Management
                 4 - Room Management
                 5 - Client Management
                 6 - Reservation Management
                 7 - Quit Program
             > """);
    }

    
    // ---------------------- Hotel ----------------------
    private void printHotelOptions() {
        printOptions("""
                Hotel Management Options:
                 1 - Display All Hotels
                 2 - Add Hotel
                 3 - Display Hotel by ID
                 4 - Update Hotel
                 5 - Delete Hotel
                 6 - Return to Main Menu
             > """);
    }

    
    private void handleHotelOptions() throws Exception {
        int cmd;
        do {
            printHotelOptions();
            cmd = scanner.nextInt();

            switch (cmd) {
                case 1 -> gestionaireHotel.displayHotels();
                case 2 -> gestionaireHotel.addHotel();
                case 3 -> gestionaireHotel.getHotelById();
                case 4 -> gestionaireHotel.updateHotel();
                case 5 -> gestionaireHotel.deleteHotel();
				case 6 -> {
					System.out.println("Returning to Main Menu");
					start();
				}
                default -> System.out.println("Invalid option");
            }
        } while (cmd != 6);
    }

    
    private Address createAddress() throws Exception {
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




    // ---------------------- End hotel gestion ----------------------
    
    
    private void printEmployeeOptions() {
		printOptions("""
				Employee Management Options:
				 1 - Display All Employees
				 2 - Add Employee
				 3 - Display Employee by ID
				 4 - Update Employee
				 5 - Delete Employee
				 6 - Return to Main Menu
				> """);
    }
    
    private void handleEmployeeOptions() throws Exception {
    	int cmd;
		do {
			printEmployeeOptions();
			cmd = scanner.nextInt();

			switch (cmd) {
			case 1 -> gestionEmployee.displayEmployees();
			case 2 -> gestionEmployee.addEmployee();
			case 3 -> gestionEmployee.getEmployeeById();
			case 4 -> gestionEmployee.updateEmployee();
			case 5 -> gestionEmployee.deleteEmployee();
			case 6 -> {
				System.out.println("Returning to Main Menu");
				start();
				}
			default -> System.out.println("Invalid option");
			}
		} while (cmd != 6);
		
    }


	
	
	// ---------------------- End Employee gestion ----------------------
	
	private void printCategoryChambreOptions() {
		printOptions("""
				Category chambres Management Options:
				 1 - Display All Category chambres
				 2 - Add Category chambre
				 3 - Display Category chambre by ID
				 4 - Update Category chambre
				 5 - Delete Category chambre
				 6 - Return to Main Menu
				> """);
	}
	
	
	
	private void handleCategoryChambreOptions() throws Exception {
		int cmd;
		do {
			printCategoryChambreOptions();
			cmd = scanner.nextInt();

			switch (cmd) {
			case 1 -> gestionCategorieChambre.displayCategorieChambres();
			case 2 -> gestionCategorieChambre.addCategorieChambre();
			case 3 -> gestionCategorieChambre.getCategorieChambreById();
			case 4 -> gestionCategorieChambre.updateCategorieChambre();
			case 5 -> gestionCategorieChambre.deleteCategorieChambre();
			case 6 -> {
				System.out.println("Returning to Main Menu");
				start();
			}
			default -> System.out.println("Invalid option");
			}
		} while (cmd != 6);
	}
	
	// ---------------------- End Category chambre gestion ----------------------

	
	
	private void printRoomOptions() {
		printOptions("""
				Room Management Options:
				 1 - Display All Rooms
				 2 - Add Room
				 3 - Display Room by ID
				 4 - Update Room
				 5 - Delete Room
				 6 - Return to Main Menu
				> """);
	}
	
	
	private void handleRoomOptions() throws Exception {
		int cmd;
		do {
			printRoomOptions();
			cmd = scanner.nextInt();
			
			switch (cmd) {
			case 1 -> gestionChambre.displayChambres();
			case 2 -> gestionChambre.addChambre();
			case 3 -> gestionChambre.getChambreById();
			case 4 -> gestionChambre.updateChambre();
			case 5 -> gestionChambre.deleteChambre();
			case 6 -> {
				System.out.println("Returning to Main Menu");
				start();
			}
			default -> System.out.println("Invalid option");
			}
		} while (cmd != 6);
		
	}
	
	// ---------------------- End Room gestion ----------------------
	
	
	private void printClientOptions() {
		printOptions("""
				Client Management Options:
				 1 - Display All Clients
				 2 - Add Client
				 3 - Display Client by ID
				 4 - Update Client
				 5 - Delete Client
				 6 - Return to Main Menu
				> """);
	}
	
	private void handleClientOptions() throws Exception {
		int cmd;
		do {
			printClientOptions();
			cmd = scanner.nextInt();

			switch (cmd) {
			case 1 -> gestionClient.displayClients();
			case 2 -> gestionClient.addClient();
			case 3 -> gestionClient.getClientById();
			case 4 -> gestionClient.updateClient();
			case 5 -> gestionClient.deleteClient();
			case 6 -> {
				System.out.println("Returning to Main Menu");
				start();
			}
			default -> System.out.println("Invalid option");
			}
		} while (cmd != 6);
	}
	
	// ---------------------- End Client gestion ----------------------
	
	
	private void printReservationOptions() {
		printOptions("""
				Reservation Management Options:
				 1 - Display All Reservations
				 2 - Add Reservation
				 3 - Display Reservation by ID
				 4 - Display Reservation by Client ID
				 5 - Update Reservation
				 6 - Delete Reservation
				 7 - Return to Main Menu
				> """);
	}
	private void handleReservationOptions() throws Exception {
		int cmd;
		do {
			printReservationOptions();
			cmd = scanner.nextInt();

			switch (cmd) {
			case 1 -> gestionReservation.displayReservations();
			case 2 -> gestionReservation.addReservation();
			case 3 -> gestionReservation.getReservationById();
			case 4 -> gestionReservation.displayReservationsByClient();
			case 5 -> gestionReservation.updateReservation();
			case 6 -> gestionReservation.deleteReservation();
			case 7 -> {
				System.out.println("Returning to Main Menu");
				start();
			}
			default -> System.out.println("Invalid option");
			}
		} while (cmd != 8);
	}


	
	
	
//	---------------------- Main ----------------------

	public void start() throws Exception {
		int cmd;
		do {
			printMainOption();
			cmd = scanner.nextInt();

			switch (cmd) {
			case 1 -> handleHotelOptions();
			case 2 -> handleEmployeeOptions();
			case 3 -> handleCategoryChambreOptions();
			case 4 -> handleRoomOptions();
			case 5 -> handleClientOptions();
			case 6 -> handleReservationOptions();
			case 7 -> System.out.println("Application closed");
			default -> System.out.println("Invalid option");
			}

		} while (cmd != 7);

		scanner.close();
	}

	

	
	
}
