package com.doranco.services;

import com.doranco.entity.Reservation;
import jakarta.persistence.EntityManager;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ReservationCommandLine {

    private final Scanner sc;
    private final ReservationService service;
    private EntityManager manager ;


    public ReservationCommandLine(){
        sc = new Scanner(System.in);
        service = new ReservationService(manager);
    }

    public void start(){
        int cmd;
        do {
            //printOption();
            cmd = sc.nextInt();
            switch (cmd) {
                case 1:
                    displayReservations();
                    break;

                case 5:
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        } while (cmd != 5);
        sc.close();
        System.out.println("Application fermée.");
    }

    private void displayReservations() {
            List<Reservation> reservations = ReservationService.findAll();
            if (reservations != null) {
                for (Reservation reservation : reservations) {
                    System.out.println("ID : " + reservation.getId());
                    System.out.println("Arrivée : " + reservation.getDateArrivee());
                    System.out.println("Départ : " + reservation.getDateDepart());
                    System.out.println("Statut : " + reservation.getStatut());
                    System.out.println("Client : " + reservation.getClient());
                    System.out.println("Chambre : " + reservation.getClient());
                    System.out.println("----------");
                }
            } else {
                System.out.println("Aucune réservation trouvé.");
            }
        }
    }


