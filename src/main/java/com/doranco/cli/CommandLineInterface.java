package com.doranco.cli;

import com.doranco.service.Gestion;

import java.util.Scanner;

public class CommandLineInterface {

    private final Gestion gestion;

    public CommandLineInterface(String persistenceUnitName) {
        gestion = new Gestion(persistenceUnitName);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            afficherMenu();
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    ajouterChambre();
                    break;
                case 2:
                    supprimerChambre();
                    break;
                case 3:
                    ajouterClient();
                    break;
                case 4:
                    supprimerClient();
                    break;
                case 5:
                    ajouterEmploye();
                    break;
                case 6:
                    supprimerEmploye();
                    break;
                case 7:
                    ajouterReservation();
                    break;
                case 8:
                    supprimerReservation();
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }
        } while (choix != 0);
    }

    private void afficherMenu() {
        System.out.println("Que souhaitez-vous faire ?");
        System.out.println("1. Ajouter une chambre");
        System.out.println("2. Supprimer une chambre");
        System.out.println("3. Ajouter un client");
        System.out.println("4. Supprimer un client");
        System.out.println("5. Ajouter un employé");
        System.out.println("6. Supprimer un employé");
        System.out.println("7. Ajouter une réservation");
        System.out.println("8. Supprimer une réservation");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }

    private void ajouterChambre() {
        gestion.ajouterChambre();
    }

    private void supprimerChambre() {
        gestion.supprimerChambre();
    }

    private void ajouterClient() {
        gestion.ajouterClient();
    }

    private void supprimerClient() {
        gestion.supprimerClient();
    }

    private void ajouterEmploye() {
        gestion.ajouterEmploye();
    }

    private void supprimerEmploye() {
        gestion.supprimerEmploye();
    }

    private void ajouterReservation() {
        gestion.ajouterReservation();
    }

    private void supprimerReservation() {
        gestion.supprimerReservation();
    }
}
