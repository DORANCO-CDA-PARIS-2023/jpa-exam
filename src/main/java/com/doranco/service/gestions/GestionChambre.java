package com.doranco.service.gestions;

import java.util.List;
import java.util.Scanner;

import com.doranco.dao.*;
import com.doranco.entity.Hotel;
import com.doranco.entity.chambres.CategorieChambre;
import com.doranco.entity.chambres.Chambre;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GestionChambre {
	private final Scanner scanner;
	private final ChambreDao chambreDao;
	private GestionaireHotel gestionaireHotel;
	
	public GestionChambre() {
		this.scanner = new Scanner(System.in);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hotel");
		EntityManager manager = factory.createEntityManager();
		this.chambreDao = new ChambreDao(manager);
		this.gestionaireHotel = new GestionaireHotel();
	}
	
	public void addChambre() throws Exception {
		System.out.print("Enter Chambre Numero: ");
		String numero = scanner.next();
		System.out.print("Enter Chambre Etage: ");
		int etage = scanner.nextInt();
		System.out.print("Enter Chambre Disponible: ");
		Boolean disponible = scanner.nextBoolean();
		System.out.print("Enter Chambre Type: ");
		String type = scanner.next();
		System.out.print("Enter Hotel ID: ");
		Long hotelId = scanner.nextLong();
		
		
		System.out.println(" ========== Category Chambre ======== ");
		System.out.print("Enter Category Chambre Name: ");
		String name = scanner.next(); 

		System.out.print("Enter Category Chambre Description: ");
		String description = scanner.next(); 

		System.out.print("Enter Category Chambre Price: ");
		Double price = scanner.nextDouble();
		
		
		Hotel hotel = gestionaireHotel.getHotelById(hotelId);

		CategorieChambre categorieChambre = new CategorieChambre(name, description, price);

		Chambre chambre = new Chambre(numero, etage, true, categorieChambre, type, hotel);
		chambreDao.addChambre(chambre);
		System.out.println("Chambre added successfully");
	}
	
	public void deleteChambre() throws Exception {
		System.out.print("Enter Chambre ID: ");
		Long id = scanner.nextLong();
		chambreDao.removeChambre(id);
		System.out.println("Chambre deleted successfully");

	}
	
	public void updateChambre() throws Exception {
		System.out.print("Enter Chambre ID: ");
		Long id = scanner.nextLong();
		Chambre chambre = chambreDao.getChambreById(id);
		System.out.print("Enter Chambre Numero: ");
		chambre.setNumero(scanner.next());
		System.out.print("Enter Chambre Etage: ");
		chambre.setEtage(scanner.nextInt());
		System.out.print("Enter Chambre Disponible: ");
		chambre.setDisponible(scanner.nextBoolean());
		System.out.print("Enter Chambre Type: ");
		chambre.setType(scanner.next());
		chambreDao.updateChambre(chambre);
		System.out.println("Chambre updated successfully");
	}
	
	public void getChambreById() {
		System.out.print("Enter Chambre ID: ");
		Long id = scanner.nextLong();
		try {
			Chambre chambre = chambreDao.getChambreById(id);
			System.out.println(chambre);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void displayChambres() {

		try {
			List<Chambre> chambres = chambreDao.getChambres();
			System.out.println("Chambres disponible: ");
			chambres.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
