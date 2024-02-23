package com.doranco.cli;


import com.doranco.entities.Customer;
import com.doranco.entities.Hotel;
import com.doranco.entities.Reservation;
import com.doranco.entities.Room;
import com.doranco.service.CustomerService;
import com.doranco.service.HotelService;
import com.doranco.service.ReservationService;
import com.doranco.service.RoomService;
import org.springframework.context.annotation.EnableMBeanExport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
@EnableMBeanExport
public class HotelManagementCLI {
    private HotelService hotelService;
    private ReservationService reservationService;
    private CustomerService customerService;
    private RoomService roomService;

    public HotelManagementCLI(HotelService hotelService, ReservationService reservationService,CustomerService customerService,RoomService roomService) {
        this.hotelService = hotelService;
        this.reservationService= reservationService;
        this.customerService=customerService;
        this.roomService=roomService;
    }

    public void start() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to Hotel Management System");
            System.out.println("1. Create Hotel");
            System.out.println("2. View All Hotels");
            System.out.println("3. Create Reservation");
            System.out.println("4. View All Reservations");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createHotel(scanner);
                    break;
                case 2:
                    viewAllHotels();
                    break;
                case 3:
                    createReservation(scanner);
                    break;
                case 4:
                    viewAllReservations();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);
    }

    private void createHotel(Scanner scanner) {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter hotel name: ");
        String name = scanner.nextLine();
        System.out.print("Enter hotel address: ");
        String address = scanner.nextLine();
        System.out.print("Enter total number of rooms: ");
        int totalRooms = scanner.nextInt();

        Hotel hotel = new Hotel();
        hotel.setName(name);
        hotel.setAddress(address);
        hotel.setTotalRooms(totalRooms);

        hotelService.create(hotel);

        System.out.println("Hotel created successfully!");
    }

    private void viewAllHotels() {
        System.out.println("List of Hotels:");
        hotelService.findAll().forEach(System.out::println);
    }

    private void createReservation(Scanner scanner) throws ParseException {
        System.out.print("Enter customer name: ");
        String customerName = scanner.next();
        // Get customer details from repository or create a new customer

        System.out.print("Enter hotel ID: ");
        Long hotelId = scanner.nextLong();
        // Get hotel details from repository

        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        // Get room details from repository
        System.out.print("Enter start date (dd/mm/yyyy): ");
        String dateStr = scanner.next();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = sdf.parse(dateStr);
        System.out.print("Enter end date (dd/mm/yyyy): ");
        String dateEnd = scanner.next();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        Date endDate = sdf.parse(dateEnd);
        Reservation reservation=new Reservation();
        Customer customer=new Customer();
        customer.setFirstName(customerName);
        Room room=new Room();
        room.setRoomNumber(roomNumber);
        System.out.println(roomService.findHotelfromHotelid(hotelId));
        room.setHotel(roomService.findHotelfromHotelid(hotelId));
        roomService.create(room);
        customerService.create(customer);
        reservation.setCustomer(customer);
        reservation.setStartDate(startDate);
        reservation.setEndDate(endDate);
        reservation.setRoom(room);
        reservationService.create(reservation);


        // Create reservation object and save it to repository
        // Reservation reservation = new Reservation();
        // Set reservation details
        // reservationRepository.save(reservation);

        System.out.println("Reservation created successfully!");
    }

    private void viewAllReservations() {
        System.out.println("List of Reservations:");
        reservationService.findAll().forEach(System.out::println);
    }


}
