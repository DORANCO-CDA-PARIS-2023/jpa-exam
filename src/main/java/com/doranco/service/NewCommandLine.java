package com.doranco.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.doranco.dao.*;
import com.doranco.entity.Hotel;
import com.doranco.entity.uers.Address;
import com.doranco.entity.uers.Moderateur;
import com.doranco.entity.uers.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NewCommandLine {

    private final Scanner scanner;
    private final HotelDao hotelDao;
    private AddressDao adresseDao;
    private ModerateurDao ModerateurDao;
    private UserDao UserDao;

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TpFinal");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public NewCommandLine() {
        scanner = new Scanner(System.in);
        hotelDao = new HotelDao(entityManager);
        adresseDao = new AddressDao(entityManager);
        ModerateurDao = new ModerateurDao(entityManager);
        UserDao = new UserDao(entityManager);
    }

    private void printOptions(String options) {
        System.out.print(options);
    }

    private void printMainOption() {
        printOptions("""
                Main Options:
                 1 - Hotel Management
                 2 - Employee Management
                 3 - Room Management
                 4 - Client Management
                 5 - Reservation Management
                 6 - Quit Program
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
                case 1 -> displayHotels();
                case 2 -> addHotel();
                case 3 -> getHotelById();
                case 4 -> updateHotel();
                case 5 -> deleteHotel();
				case 6 -> {
					System.out.println("Returning to Main Menu");
					start();
				}
                default -> System.out.println("Invalid option");
            }
        } while (cmd != 6);
    }

    private void addHotel() throws Exception {
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



    private void displayHotels() {
        try {
            List<Hotel> hotels = hotelDao.getHotels();
            System.out.println("Hotels disponible: ");
            hotels.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getHotelById() throws Exception {
        System.out.print("Enter Hotel ID: ");
        Long id = scanner.nextLong();
        Hotel hotel = hotelDao.getHotelById(id);
        System.out.println(hotel);
    }

    private void updateHotel() throws Exception {
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

    private void deleteHotel() throws Exception {
		System.out.print("Enter Hotel ID: ");
		Long id = scanner.nextLong();
		hotelDao.removeHotel(id);
		System.out.println("Hotel deleted successfully");
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
			case 1 -> displayEmployees();
			case 2 -> addEmployee();
			case 3 -> getEmployeeById();
			case 4 -> updateEmployee();
			case 5 -> deleteEmployee();
			case 6 -> {
				System.out.println("Returning to Main Menu");
				start();
				}
			default -> System.out.println("Invalid option");
			}
		} while (cmd != 6);
		
    }

	private void deleteEmployee() throws Exception {
		System.out.print("Enter Employee ID: ");
		Long id = scanner.nextLong();
		ModerateurDao.removeModerateur(id);
		System.out.println("Employee deleted successfully");
		
	}

	private void updateEmployee() throws Exception {
		System.out.print("Enter Employee ID: ");
        Long id = scanner.nextLong();
        Moderateur moderateur = ModerateurDao.getModerateurById(id);
        System.out.print("Enter Employee First Name: ");
        moderateur.setFirstName(scanner.next());
        System.out.print("Enter Employee Last Name: ");
        moderateur.setLastName(scanner.next());
        System.out.print("Enter Employee Téléphone: ");
        moderateur.setTelephone(scanner.next());
        System.out.print("Enter Employee gender: ");
        moderateur.setGender(scanner.next());
        System.out.print("Enter Employee date de naissance (DD/MM/YYYY): ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateOfBirth = LocalDate.parse(scanner.next(), formatter);
        ModerateurDao.updateModerateur(moderateur);
        System.out.println("Employee updated successfully");
	}

	private void getEmployeeById() {
		System.out.print("Enter Employee ID: ");
		Long id = scanner.nextLong();
		try {
			Moderateur moderateur = ModerateurDao.getModerateurById(id);
			System.out.println(moderateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void displayEmployees() {
		
		try {
			List<Moderateur> employees = ModerateurDao.getModerateurs();
			System.out.println("Employees disponible: ");
			employees.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Object addEmployee() throws Exception {
		System.out.print("Enter Employee First Name: ");
		String firstName = scanner.next(); 
		System.out.print("Enter Employee Last Name: ");
		String lastName = scanner.next();
		System.out.print("Enter Employee Téléphone: ");
		String telephone = scanner.next();
		System.out.print("Enter Employee gender: ");
		String gender = scanner.next();
		System.out.print("Enter Employee date de naissance (DD/MM/YYYY): ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateOfBirth = LocalDate.parse(scanner.next(), formatter);
		
//		System.out.print("Enter Employee Address: ");
		Address address = createAddress();
		
//		System.out.print("Enter User: ");
		User user = createUser();
		
		Moderateur moderateur = new Moderateur(firstName, lastName, telephone, gender, dateOfBirth, address, user);
		ModerateurDao.addModerateur(moderateur);
		return null;
	}

	private User createUser() throws Exception {
		System.out.print(" =========== Enter User username: ============= ");
		String username = scanner.next();
		System.out.print("Enter User password: ");
		String password = scanner.next();
		System.out.print("Enter User email: ");
		String email = scanner.next();
		String role = "moderateur";
		
		User user = new User(username, password, email, role);
		UserDao.addUser(user);
		System.out.println("User added successfully");
		return user;
	}

	private Object handleReservationOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object handleClientOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object handleRoomOptions() {
		// TODO Auto-generated method stub
		return null;
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
			case 3 -> handleRoomOptions();
			case 4 -> handleClientOptions();
			case 5 -> handleReservationOptions();
			case 6 -> System.out.println("Application closed");
			default -> System.out.println("Invalid option");
			}

		} while (cmd != 6);

		scanner.close();
	}

	
	
}
