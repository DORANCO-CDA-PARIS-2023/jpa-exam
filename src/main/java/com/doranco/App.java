package com.doranco;

import com.doranco.service.HotelService;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ajout nouvelle hôtel :");
        System.out.print("Nom ? ");
        String nomHotel = scanner.nextLine();

        System.out.print("Adresse ? ");
        String adresseHotel = scanner.nextLine();

        System.out.print("Chambres disponibles ? ");
        int nbChambresDisponibles = scanner.nextInt();
        HotelService hotelService = new HotelService();
        hotelService.ajouterHotel(nomHotel, adresseHotel, nbChambresDisponibles);
        hotelService.close();
        scanner.close();
    }
}
