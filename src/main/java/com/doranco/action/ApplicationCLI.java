package com.doranco.action;


import java.io.InputStream;
import java.util.Scanner;
import com.doranco.services.HotelService;

public class ApplicationCLI {

    private final Scanner scanner;
    private final HotelService hotelService;

    public ApplicationCLI(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
        this.hotelService = new HotelService(); // Initialisez votre service de gestion d'hôtel
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();
            switch (choice) {
                case 1:
                    addHotel();
                    break;
                case 2:
                    addRoom();
                    break;
                case 3:
                    makeReservation();
                    break;
                case 4:
                    addEmployee();
                    break;
                case 5:
                    addClient();
                    break;
                case 6:
                    addService();
                    break;
                case 7:
                    generateInvoice();
                    break;
                case 8:
                    displayDetails();
                    break;
                case 9:
                    updateDetails();
                    break;
                case 10:
                    deleteEntity();
                    break;
                case 11:
                    System.out.println("Sortie...");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
        } while (choice != 11);
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("========================================");
        System.out.println("1. Ajouter un Hôtel");
        System.out.println("2. Ajouter une Chambre");
        System.out.println("3. Faire une Réservation");
        System.out.println("4. Ajouter un Employé");
        System.out.println("5. Ajouter un Client");
        System.out.println("6. Ajouter un Service");
        System.out.println("7. Générer une Facture");
        System.out.println("8. Afficher les Détails");
        System.out.println("9. Mettre à Jour les Détails");
        System.out.println("10. Supprimer une Entité");
        System.out.println("11. Sortie");
        System.out.println("========================================");
    }

    private int getUserChoice() {
        System.out.print("Entrez votre choix : ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrée invalide. Veuillez entrer un nombre.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void addHotel() {
        System.out.println("Entrez le nom de l'hôtel : ");
        String nom = scanner.next(); // Utiliser scanner.next() pour lire un seul mot
        scanner.nextLine(); // Ignorer le reste de la ligne
        System.out.println("Entrez l'adresse de l'hôtel : ");
        String adresse = scanner.nextLine();
        System.out.println("Entrez le nombre total de chambres disponibles : ");
        int nombreChambres;
        while (true) {
            try {
                nombreChambres = Integer.parseInt(scanner.nextLine());
                break; // Sortir de la boucle si la conversion a réussi
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide pour le nombre de chambres.");
            }
        }
        // Appelez votre service de gestion d'hôtel pour ajouter l'hôtel avec les informations fournies
        hotelService.addHotel(nom, adresse, nombreChambres);
        System.out.println("L'hôtel a été ajouté avec succès !");
    }

    private void addRoom() {
        // Logique pour ajouter une chambre
    }

    private void makeReservation() {
        // Logique pour faire une réservation
    }

    private void addEmployee() {
        // Logique pour ajouter un employé
    }

    private void addClient() {
        // Logique pour ajouter un client
    }

    private void addService() {
        // Logique pour ajouter un service
    }

    private void generateInvoice() {
        // Logique pour générer une facture
    }

    private void displayDetails() {
        // Logique pour afficher les détails
    }

    private void updateDetails() {
        // Logique pour mettre à jour les détails
    }

    private void deleteEntity() {
        // Logique pour supprimer une entité
    }
}
