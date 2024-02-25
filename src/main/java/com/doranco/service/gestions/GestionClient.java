package com.doranco.service.gestions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.doranco.dao.*;
import com.doranco.entity.uers.Address;
import com.doranco.entity.uers.Client;
import com.doranco.entity.uers.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GestionClient {

	private final Scanner scanner;
	private final ClientDao clientDao;
	private final AddressDao adresseDao;
	private final UserDao userDao;

	public GestionClient() {
		this.scanner = new Scanner(System.in);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hotel");
		EntityManager manager = factory.createEntityManager();
		this.clientDao = new ClientDao(manager);
		this.userDao = new UserDao(manager);
		this.adresseDao = new AddressDao(manager);
	}

	public void addClient() throws Exception {
		System.out.print("Enter Client First Name: ");
		String firstName = scanner.next();
		System.out.print("Enter Client Last Name: ");
		String lastName = scanner.next();
		System.out.print("Enter Client Téléphone: ");
		String telephone = scanner.next();
		System.out.print("Enter Client gender: ");
		String gender = scanner.next();
		System.out.print("Enter Client date de naissance (DD/MM/YYYY): ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateOfBirth = LocalDate.parse(scanner.next(), formatter);

		Address address = createAddress();

		User user = createUser();

		Client client = new Client(firstName, lastName, telephone, gender, dateOfBirth, address, user);
		clientDao.addClient(client);
		System.out.println("Client added successfully");

	}

	public void deleteClient() throws Exception {
		System.out.print("Enter Client ID: ");
		Long id = scanner.nextLong();
		clientDao.removeClient(id);
		System.out.println("Client deleted successfully");
	}

	public void updateClient() throws Exception {
		System.out.print("Enter Client ID: ");
		Long id = scanner.nextLong();
		Client client = clientDao.getClientById(id);
		System.out.print("Enter Client First Name: ");
		client.setFirstName(scanner.next());
		System.out.print("Enter Client Last Name: ");
		client.setLastName(scanner.next());
		System.out.print("Enter Client Téléphone: ");
		client.setTelephone(scanner.next());
		System.out.print("Enter Client gender: ");
		client.setGender(scanner.next());
		System.out.print("Enter Client date de naissance (DD/MM/YYYY): ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateOfBirth = LocalDate.parse(scanner.next(), formatter);
		clientDao.updateClient(client);
		System.out.println("Client updated successfully");

	}

	public void getClientById() {
		System.out.print("Enter Client ID: ");
		Long id = scanner.nextLong();
		try {
			Client client = clientDao.getClientById(id);
			System.out.println(client);
		} catch (Exception e) {
			System.out.println("Client not found");
		}
	}
	
	public Client getClientById(Long id) {
		System.out.print("Enter Client ID: ");
		try {
			Client client = clientDao.getClientById(id);
			System.out.println(client);
			return client;
		} catch (Exception e) {
			System.out.println("Client not found");
		}
		return null;
	}

	public void displayClients() {
		try {
			List<Client> clients = clientDao.getClients();
			System.out.println("Clients disponible: ");
			clients.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
