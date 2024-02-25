package com.doranco.service.gestions;

import java.util.List;
import java.util.Scanner;

import com.doranco.dao.*;
import com.doranco.entity.chambres.CategorieChambre;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GestionCategorieChambre {

	private final Scanner scanner;
	private final CategorieChambreDao categorieChambreDao;
	
	public GestionCategorieChambre() {
		this.scanner = new Scanner(System.in);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hotel");
		EntityManager manager = factory.createEntityManager();
		this.categorieChambreDao = new CategorieChambreDao(manager);
	}
	
	public void addCategorieChambre() throws Exception {
		System.out.print("Enter CategorieChambre Name: ");
		String name = scanner.next(); // Consume newline character

		System.out.print("Enter CategorieChambre Description: ");
		String description = scanner.next(); // Consume newline character

		System.out.print("Enter CategorieChambre Price: ");
		Double price = scanner.nextDouble();

		CategorieChambre categorieChambre = new CategorieChambre(name, description, price);

		categorieChambreDao.addCategorieChambre(categorieChambre);
		System.out.println("CategorieChambre added successfully");
	}
	
	
	public void deleteCategorieChambre() throws Exception {
		System.out.print("Enter CategorieChambre ID: ");
		Long id = scanner.nextLong();
		categorieChambreDao.removeCategorieChambre(id);
		System.out.println("CategorieChambre deleted successfully");

	}
	
	public void updateCategorieChambre() throws Exception {
		System.out.print("Enter CategorieChambre ID: ");
		Long id = scanner.nextLong();
		CategorieChambre categorieChambre = categorieChambreDao.getCategorieChambreById(id);
		System.out.print("Enter CategorieChambre Name: ");
		categorieChambre.setNom(scanner.next());
		System.out.print("Enter CategorieChambre Description: ");
		categorieChambre.setDescription(scanner.next());
		System.out.print("Enter CategorieChambre Price: ");
		categorieChambre.setPrix(scanner.nextDouble());
		categorieChambreDao.updateCategorieChambre(categorieChambre);
		System.out.println("CategorieChambre updated successfully");
	}
	
	public void getCategorieChambreById() {
		System.out.print("Enter CategorieChambre ID: ");
		Long id = scanner.nextLong();
		try {
			CategorieChambre categorieChambre = categorieChambreDao.getCategorieChambreById(id);
			System.out.println(categorieChambre);
		} catch (Exception e) {
			System.out.println("CategorieChambre not found");
		}
	}
	
	
	public void displayCategorieChambres() {
		try {
			List<CategorieChambre> categorieChambres = categorieChambreDao.getCategoriesChambre();
			System.out.println("CategorieChambres disponible: ");
			categorieChambres.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
