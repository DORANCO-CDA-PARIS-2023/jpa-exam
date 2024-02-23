package com.doranco;

import com.doranco.entity.Hotel;
import com.doranco.service.ChambreService;
import com.doranco.service.HotelService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Ajouter hôtel");
        System.out.println("2. Ajouter des chambres");
        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
                ajouterNouvelHotel();
                break;
            case 2:
                ajouterChambresAHotel();
                break;
            default:
                System.out.println("Choix invalide");
        }

        scanner.close();
    }

    public static void ajouterNouvelHotel() {
        Scanner scanner = new Scanner(System.in);
        HotelService hotelService = new HotelService();

        System.out.println("Ajout d'un nouvel hôtel :");
        System.out.print("Nom ? ");
        String nomHotel = scanner.nextLine();

        System.out.print("Adresse ? ");
        String adresseHotel = scanner.nextLine();

        System.out.print("Chambres disponibles ? ");
        int nbChambresDisponibles = scanner.nextInt();

        hotelService.ajouterHotel(nomHotel, adresseHotel, nbChambresDisponibles);
        hotelService.close();
        scanner.close();
    }

    public static void ajouterChambresAHotel() {
        Scanner scanner = new Scanner(System.in);
        ChambreService chambreService = new ChambreService();

        System.out.print("ID Hotel ? ");
        Long idHotel = scanner.nextLong();
        scanner.nextLine();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TpFinal");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Hotel hotel = entityManager.find(Hotel.class, idHotel);
        entityManager.close();
        entityManagerFactory.close();

        if (hotel != null) {
            System.out.print("Nombre de chambres à ajouter ? ");
            int nbChambres = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < nbChambres; i++) {
                System.out.println("Chambre" + (i + 1) + " :");
                System.out.print("Numéro ? ");
                String numero = scanner.nextLine();

                System.out.print("Type ? ");
                String type = scanner.nextLine();

                System.out.print("Prix ? ");
                double prixParNuit = scanner.nextDouble();
                scanner.nextLine();

                chambreService.ajouterChambre(numero, type, prixParNuit, hotel);
            }
        } else {
            System.out.println("Aucun hôtel n'a cette ID.");
        }

        chambreService.close();
        scanner.close();
    }

}
