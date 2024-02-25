package com.doranco.service.gestions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.doranco.dao.AddressDao;
import com.doranco.dao.ModerateurDao;
import com.doranco.dao.UserDao;
import com.doranco.entity.uers.Address;
import com.doranco.entity.uers.Moderateur;
import com.doranco.entity.uers.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GestionEmployee {
	
	private final Scanner scanner;
	private final ModerateurDao moderateurDao;
	private AddressDao adresseDao;
	private UserDao userDao;
	
	public GestionEmployee() {
		this.scanner = new Scanner(System.in);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hotel");
		EntityManager manager = factory.createEntityManager();
		this.moderateurDao = new ModerateurDao(manager);
		this.adresseDao = new AddressDao(manager);
		this.userDao = new UserDao(manager);
	}
	
	public void deleteEmployee() throws Exception {
		System.out.print("Enter Employee ID: ");
		Long id = scanner.nextLong();
		moderateurDao.removeModerateur(id);
		System.out.println("Employee deleted successfully");
		
	}

	public void updateEmployee() throws Exception {
		System.out.print("Enter Employee ID: ");
        Long id = scanner.nextLong();
        Moderateur moderateur = moderateurDao.getModerateurById(id);
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
		moderateurDao.updateModerateur(moderateur);
        System.out.println("Employee updated successfully");
	}

	public void getEmployeeById() {
		System.out.print("Enter Employee ID: ");
		Long id = scanner.nextLong();
		try {
			Moderateur moderateur = moderateurDao.getModerateurById(id);
			System.out.println(moderateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayEmployees() {
		
		try {
			List<Moderateur> employees = moderateurDao.getModerateurs();
			System.out.println("Employees disponible: ");
			employees.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addEmployee() throws Exception {
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
		
//		System.out.println(" ======= Enter Address: ============ ");
		Address address = createAddress();
		
//		System.out.println(" ======= Enter User: ============ ");
		User user = createUser();
		
		Moderateur moderateur = new Moderateur(firstName, lastName, telephone, gender, dateOfBirth, address, user);
		moderateurDao.addModerateur(moderateur);
	}

	public User createUser() throws Exception {
		System.out.print(" =========== Enter User username: ============= ");
		String username = scanner.next();
		System.out.print("Enter User password: ");
		String password = scanner.next();
		System.out.print("Enter User email: ");
		String email = scanner.next();
		String role = "moderateur";
		
		User user = new User(username, password, email, role);
		userDao.addUser(user);
		System.out.println("User added successfully");
		return user;
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

}
