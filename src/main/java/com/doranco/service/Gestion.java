package com.doranco.service;

import com.doranco.entity.*;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Scanner;

public class Gestion {

    private final EntityManagerFactory emf;

    public Gestion(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    public void ajouterChambre() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le numéro de chambre : ");
        String numero = scanner.nextLine();
        System.out.println("Entrez le type de chambre : ");
        String type = scanner.nextLine();
        System.out.println("Entrez le prix par nuit : ");
        double prix = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("La chambre est-elle disponible ? (true/false) : ");
        boolean disponibilite = scanner.nextBoolean();

        Chambre chambre = new Chambre(numero, type, prix, disponibilite);
        em.persist(chambre);

        em.getTransaction().commit();
        em.close();
        System.out.println("Chambre ajoutée avec succès.");
    }

    public void supprimerChambre() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez l'ID de la chambre à supprimer : ");
        long id = scanner.nextLong();
        Chambre chambre = em.find(Chambre.class, id);
        if (chambre != null) {
            em.remove(chambre);
            System.out.println("Chambre supprimée avec succès.");
        } else {
            System.out.println("Aucune chambre trouvée avec cet ID.");
        }

        em.getTransaction().commit();
        em.close();
    }

    public void ajouterClient() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le prénom du client : ");
        String prenom = scanner.nextLine();
        System.out.println("Entrez le nom du client : ");
        String nom = scanner.nextLine();

        Client client = new Client(prenom, nom);
        em.persist(client);

        em.getTransaction().commit();
        em.close();
        System.out.println("Client ajouté avec succès.");
    }

    public void supprimerClient() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez l'ID du client à supprimer : ");
        long id = scanner.nextLong();
        Client client = em.find(Client.class, id);
        if (client != null) {
            em.remove(client);
            System.out.println("Client supprimé avec succès.");
        } else {
            System.out.println("Aucun client trouvé avec cet ID.");
        }

        em.getTransaction().commit();
        em.close();
    }

    public void ajouterEmploye() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le prénom de l'employé : ");
        String prenom = scanner.nextLine();
        System.out.println("Entrez le nom de l'employé : ");
        String nom = scanner.nextLine();
        System.out.println("Entrez le poste de l'employé : ");
        String poste = scanner.nextLine();

        Employe employe = new Employe(prenom, nom, poste);
        em.persist(employe);

        em.getTransaction().commit();
        em.close();
        System.out.println("Employé ajouté avec succès.");
    }

    public void supprimerEmploye() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez l'ID de l'employé à supprimer : ");
        long id = scanner.nextLong();
        Employe employe = em.find(Employe.class, id);
        if (employe != null) {
            em.remove(employe);
            System.out.println("Employé supprimé avec succès.");
        } else {
            System.out.println("Aucun employé trouvé avec cet ID.");
        }

        em.getTransaction().commit();
        em.close();
    }

    public void ajouterReservation() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez l'ID du client pour la réservation : ");
        long idClient = scanner.nextLong();
        Client client = em.find(Client.class, idClient);
        if (client == null) {
            System.out.println("Aucun client trouvé avec cet ID.");
            return;
        }

        System.out.println("Entrez l'ID de la chambre pour la réservation : ");
        long idChambre = scanner.nextLong();
        Chambre chambre = em.find(Chambre.class, idChambre);
        if (chambre == null) {
            System.out.println("Aucune chambre trouvé avec cet ID.");
            return;
        }

        System.out.println("Entrez la date de début de la réservation (format : yyyy-MM-dd) : ");
        String debutStr = scanner.next();
        System.out.println("Entrez la date de fin de la réservation (format : yyyy-MM-dd) : ");
        String finStr = scanner.next();

        Date debut = java.sql.Date.valueOf(debutStr);
        Date fin = java.sql.Date.valueOf(finStr);

        Reservation reservation = new Reservation(debut, fin, chambre, client);
        em.persist(reservation);

        em.getTransaction().commit();
        em.close();
        System.out.println("Réservation ajoutée avec succès.");
    }

    public void supprimerReservation() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez l'ID de la réservation à supprimer : ");
        long id = scanner.nextLong();
        Reservation reservation = em.find(Reservation.class, id);
        if (reservation != null) {
            em.remove(reservation);
            System.out.println("Réservation supprimée avec succès.");
        } else {
            System.out.println("Aucune réservation trouvée avec cet ID.");
        }

        em.getTransaction().commit();
        em.close();
    }
}
