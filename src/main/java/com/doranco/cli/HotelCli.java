package com.doranco.cli;

import java.util.Scanner;

import com.doranco.entity.Hotel;
import com.doranco.entity.Room;
import com.doranco.service.HotelService;
import com.doranco.service.RoomService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class HotelCli {
	
	EntityManagerFactory ef;
	
	public HotelCli(EntityManagerFactory ef) {
		this.ef = ef;
	}

	public void start() {
  		 EntityManager em = ef.createEntityManager();
  		 HotelService hs = new HotelService(em);
  		 RoomService rs = new RoomService(em);
    	int choice = 0;
    	Scanner sc = new Scanner(System.in);
    	while(choice != 1) {
    	System.out.println("""
    			Quelle action souhaitez-vous effectuer ?
    			1 - Fermer l'application
    			2 - Afficher tous les hôtels
    			3 - Ajouter un hôtel
    			4 - Supprimer un hôtel
    			5 - Ajouter une chambre à un hôtel
    			6 - Afficher toutes les chambres d'un hôtel
    			7 - Supprimer une chambre
    			8 - Ajouter un client
    			3 - Afficher tous les clients
    			4 - Supprimer un client
    			""");
    	System.out.print("Votre choix : ");
    	choice = sc.nextInt();
    	if(choice == 1) {
    		System.out.println("Fermeture du programme ...");
        	sc.close();
        	em.close();
        	ef.close();
        	
    	} else if (choice == 2) {
    		for(Hotel hotel : hs.findAll()) {
    			System.out.println(hotel.toString());
    		}
    		
    	}else if (choice == 3) {
    		Hotel hotelToAdd = new Hotel();
    		System.out.println("Nom de l'hôtel : ");
    		sc = new Scanner(System.in);
    		hotelToAdd.setName(sc.nextLine());
    		System.out.println("Adresse de l'hôtel : ");
    		sc = new Scanner(System.in);
    		hotelToAdd.setAddress(sc.nextLine());
    		System.out.println("Nombre de chambres : ");
    		hotelToAdd.setNumberOfRooms(sc.nextInt());
    		hs.create(hotelToAdd);
    		
    	}else if (choice == 4) {
        	System.out.print("ID de l'hôtel à supprimer : ");
    		sc = new Scanner(System.in);
    		int hotelIdToRemove = sc.nextInt();
    		hs.remove(hotelIdToRemove);
    		
    	}else if (choice == 5) {
    		Room roomToAdd = new Room();
        	System.out.print("ID de l'hôtel dans lequel ajouter la chambre : ");
    		sc = new Scanner(System.in);
    		int idHotelChambreAjout = sc.nextInt();
    		roomToAdd.setHotel(hs.findById(idHotelChambreAjout));
        	System.out.print("Nom/numéro de la chambre : ");
    		sc = new Scanner(System.in);
    		roomToAdd.setNumber(sc.nextLine());
        	System.out.print("Taille de la chambre : ");
    		sc = new Scanner(System.in);
    		roomToAdd.setSize(sc.nextInt());
        	System.out.print("Prix par nuit : ");
    		sc = new Scanner(System.in);
    		roomToAdd.setPricePerNight(sc.nextInt());
    		rs.create(roomToAdd);
    		
    	}else if (choice == 6) {
        	System.out.print("ID de l'hôtel duquel afficher les chambres : ");
    		sc = new Scanner(System.in);
    		int idHotelChambreRecherche = sc.nextInt();
    		for(Room room : hs.findById(idHotelChambreRecherche).getRooms()) {
    			System.out.println(room.toString());
    		}
    		
    	}else if (choice == 7) {
        	System.out.print("ID de la chambre à supprimer : ");
    		sc = new Scanner(System.in);
    		int roomIdToRemove = sc.nextInt();
    		rs.remove(roomIdToRemove);
    		
    	}else if (choice == 8) {
    		
    	}else if (choice == 9) {
    		
    	}else if (choice == 10) {
    		
    	}else if (choice == 11) {
    		
    	}else if (choice == 12) {
    		
    	}else if (choice == 13) {
    		
    	}else if (choice == 14) {
    		
    	}else if (choice == 15) {
    		
    	}else if (choice == 16) {
    		
    	}else if (choice == 17) {
    		
    	}
    	}
    	System.out.println("Action effectuée.");
	}
}
