package com.doranco.service;

import java.util.List;
import java.util.Scanner;

import com.doranco.dao.*;
import com.doranco.entity.Hotel;
import com.doranco.entity.uers.Address;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CommandLineOlde3 {

    private final Scanner scanner;
    private final HotelDao hotelDao;
    private final AddressDao addressDao;

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TpFinal");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public CommandLineOlde3() {
        scanner = new Scanner(System.in);
        hotelDao = new HotelDao(entityManager);
        addressDao = new AddressDao(entityManager);
    }

    private void printOptions(String options) {
        System.out.print(options);
    }

    private void printMainOption() {
        printOptions("""
                Option :
                     1 - Hotel Management
                     2 - Address Management
                     3 - Quit Program
                 > """);
    }

    private void printSubMenu(String options) {
        printOptions(options);
    }

    public void start() throws Exception {
        int cmd;
        do {
            printMainOption();
            cmd = scanner.nextInt();

            switch (cmd) {
                case 1 -> handleHotelOptions();
                case 2 -> handleAddressOptions();
                case 3 -> System.out.println("Program closed");
                default -> System.out.println("Invalid option");
            }
        } while (cmd != 3);
        scanner.close();
    }

    private void handleHotelOptions() throws Exception {
        int cmd;
        do {
            printOptions("""
                    Option :
                         1 - Add Hotel
                         2 - Display Hotels
                         3 - Get Hotel by ID
                         4 - Update Hotel
                         5 - Delete Hotel
                         6 - Return to Main Menu
                     > """);
            cmd = scanner.nextInt();

            switch (cmd) {
                case 1 -> addHotel();
                case 2 -> displayHotels();
                case 3 -> getHotelById();
                case 4 -> updateHotel();
                case 5 -> deleteHotel();
                case 6 -> System.out.println("Returning to the main menu");
                default -> System.out.println("Invalid option");
            }
        } while (cmd != 6);
    }

    private void addHotel() throws Exception {
        // Your existing code for adding a hotel
    }

    private List<Hotel> displayHotels() {
        try {
            return hotelDao.getHotels();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Hotel getHotelById() throws Exception {
        System.out.print("Enter Hotel ID: ");
        Long id = scanner.nextLong();
        return hotelDao.getHotelById(id);
    }

    private void updateHotel() {
        // Your existing code for updating a hotel
    }

    private void deleteHotel() {
        // Your existing code for deleting a hotel
    }

    private void handleAddressOptions() {
        // Your existing code for handling address-related options
    }
}
