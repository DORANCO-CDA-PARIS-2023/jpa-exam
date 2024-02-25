package com.doranco.service.gestions;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.doranco.dao.ChambreDao;
import com.doranco.dao.ClientDao;
import com.doranco.dao.HotelDao;
import com.doranco.dao.ReservationDao;
import com.doranco.entity.Hotel;
import com.doranco.entity.chambres.Chambre;
import com.doranco.entity.chambres.Reservation;

import ch.qos.logback.core.net.server.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GestionReservation {

	private final Scanner scanner;
	private final ReservationDao reservationDao;
	private final ClientDao clientDao;
	private final ChambreDao chambreDao;
	private final HotelDao hotelDao;
	private final GestionClient gestionClient;
	
	
	public GestionReservation() {
		this.scanner = new Scanner(System.in);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hotel");
		EntityManager manager = factory.createEntityManager();
		this.reservationDao = new ReservationDao(manager);
		this.clientDao = new ClientDao(manager);
		this.chambreDao = new ChambreDao(manager);
		this.hotelDao = new HotelDao(manager);
		this.gestionClient = new GestionClient();
	}
	
	public void addReservation() throws Exception {
		System.out.print("Enter Client ID: ");
		Long clientId = scanner.nextLong();
		
		Client client = (Client) gestionClient.getClientById(clientId);
		if (client == null) {
			System.out.println("Client not found");
			return;
		}
		
		System.out.print("Enter Chambre ID: ");
		Long chambreId = scanner.nextLong();
		
		Chambre chambre = chambreDao.getChambreById(chambreId);
		if (chambre == null) {
			System.out.println("Chambre not found");
			return;
		}
		
		System.out.print("Enter Hotel ID: ");
		Long hotelId = scanner.nextLong();
				
		Hotel hotel = hotelDao.getHotelById(hotelId);
		
		if (hotel == null) {
			System.out.println("Hotel not found");
			return;
		}
		
		System.out.print("Enter Date de debut (DD/MM/YYYY): ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateDebut = LocalDate.parse(scanner.next(), formatter);
		
		System.out.print("Enter Date de fin (DD/MM/YYYY): ");
		LocalDate dateFin = LocalDate.parse(scanner.next(), formatter);
		
		System.out.print("Enter Reservation Status: ");
		Boolean annulee = scanner.nextBoolean();
		
		System.out.print("Enter Reservation Payée: ");
		Boolean payee = scanner.nextBoolean();
		
		Reservation reservation = new Reservation(dateDebut, dateFin, annulee, payee, chambre, client, hotel);
		
		reservationDao.addReservation(reservation);
		System.out.println("Reservation added successfully");
	}
	
	public void deleteReservation() throws Exception {
		System.out.print("Enter Reservation ID: ");
		Long id = scanner.nextLong();
		reservationDao.removeReservation(id);
		System.out.println("Reservation deleted successfully");
	}
	
	public void updateReservation() throws Exception {
		System.out.print("Enter Reservation ID: ");
		Long id = scanner.nextLong();
		Reservation reservation = reservationDao.getReservationById(id);
		System.out.print("Enter Date de debut (DD/MM/YYYY): ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateDebut = LocalDate.parse(scanner.next(), formatter);
		reservation.setDateDebut(dateDebut);
		System.out.print("Enter Date de fin (DD/MM/YYYY): ");
		LocalDate dateFin = LocalDate.parse(scanner.next(), formatter);
		reservation.setDateFin(dateFin);
		System.out.print("Enter Reservation Status: ");
		reservation.setAnnulee(scanner.nextBoolean());
		System.out.print("Enter Reservation Payée: ");
		reservation.setPayee(scanner.nextBoolean());
		reservationDao.updateReservation(reservation);
		System.out.println("Reservation updated successfully");
	}
	
	
	public void getReservationById() {
		System.out.print("Enter Reservation ID: ");
		Long id = scanner.nextLong();
		try {
			Reservation reservation = reservationDao.getReservationById(id);
			System.out.println(reservation);
		} catch (Exception e) {
			System.out.println("Reservation not found");
		}
	}
	
	
	public void displayReservations() {
		try {
			List<Reservation> reservations = reservationDao.getReservations();
			System.out.println("Reservations disponible: ");
			reservations.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void displayReservationsByClient() {
		System.out.print("Enter Client ID: ");
		Long clientId = scanner.nextLong();
		try {
			List<Reservation> reservations = reservationDao.getReservationsByClientId(clientId);
			System.out.println("Reservations disponible: ");
			reservations.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
