package com.doranco.jpaexam.service;

import com.doranco.jpaexam.entity.Bedroom;
import com.doranco.jpaexam.entity.Employee;
import com.doranco.jpaexam.entity.Hotel;
import com.doranco.jpaexam.utils.ScannerUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActionData {

    private final EntityManager em;
    private final ActionType actionType;
    private final DataType dataType;
    private final Scanner sc;
    private final ScannerUtils scUtils;
    private final String largeSeparator = "========================================================================================";
    private final String mediumSeparator = "----------------------------------------------------------------------------------------";


    public ActionData(ActionType actionType, DataType dataType, Scanner sc, EntityManager em) {
        this.actionType = actionType;
        this.dataType = dataType;
        this.sc = sc;
        this.scUtils = new ScannerUtils(sc);
        this.em = em;
    }

    public void execute() {
        switch (dataType) {
            case BEDROOM -> treatBedroom();
            case HOTEL -> treatHotel();
            case CLIENT -> treatClient();
            case BOOKING -> treatBooking();
            case SERVICE -> treatService();
            case EMPLOYEE -> treatEmployee();
        }
    }

    private void treatBedroom() {
        switch (actionType) {
            case CREATE -> {
                Bedroom bedroom = new Bedroom();

                long hotelId = scUtils.getLong(
                        "Entrez l'id de l'hôtel où se trouve la chambre → ",
                        1,
                        Long.MAX_VALUE
                );

                Hotel hotel = em.find(Hotel.class, hotelId);
                if (hotel == null) {
                    System.out.println("Il n'y a aucun hotel avec cette id.");
                    System.out.println(largeSeparator);
                    return;
                }

                bedroom.setHotel(hotel);
                bedroom.setNumber(scUtils.getString(
                        "Entrez le numéro de la chambre → ",
                        false
                ));
                bedroom.setType(scUtils.getString(
                        "Entrez le type de la chambre → ",
                        false
                ));
                bedroom.setPrice(scUtils.getFloat(
                        "Entrez le prix de la chambre → ",
                        0,
                        Float.MAX_VALUE
                ));


                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.persist(bedroom);
                transaction.commit();
                System.out.println("La chambre a été crée avec succès dans l'hôtel " + hotel.getName() + "." );
                System.out.println(largeSeparator);
            }
            case READ -> {
                String prompt = String.format("""
                        %s
                        1. Afficher toutes les chambres
                        2. Chercher une chambre par numéro
                        3. Chercher une chambre par id
                        %s
                        → """,
                        largeSeparator, largeSeparator);

                int choice = scUtils.getInt(prompt, 1, 3);

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                List<Bedroom> bedroomList = new ArrayList<>();
                if (choice == 1) {
                    TypedQuery<Bedroom> findAll = em.createNamedQuery("findAllBedroom", Bedroom.class);
                    bedroomList.addAll(findAll.getResultList());
                } else if (choice == 2) {
                    String numero = scUtils.getString(
                            "Entrez le numéro de la chambre recherché → ",
                            false
                    );
                    TypedQuery<Bedroom> findByName = em.createNamedQuery("findBedroomByNumber", Bedroom.class);
                    findByName.setParameter("number", numero);
                    bedroomList.addAll(findByName.getResultList());
                } else {
                    long id = scUtils.getLong(
                            "Entrez l'id de la chambre recherché → ",
                            1l,
                            Long.MAX_VALUE
                    );
                    Bedroom bedroom = em.find(Bedroom.class, id);
                    if (bedroom != null) {
                        bedroomList.add(bedroom);
                    }
                }
                transaction.commit();

                System.out.println(mediumSeparator);
                System.out.println("Résultat:");
                bedroomList.stream().map(Bedroom::toString).forEach(System.out::println);
                System.out.println(largeSeparator);
            }
            case UPDATE -> {
                long id = scUtils.getLong(
                        "Entrez l'id de la chambre à modifier → ",
                        1,
                        Long.MAX_VALUE
                );

                Bedroom bedroom = em.find(Bedroom.class, id);
                if (bedroom == null) {
                    System.out.println("Cette id ne correspond à aucune chambre existante.");
                    System.out.println(largeSeparator);
                    return;
                }

                long hotelId = scUtils.getLong(
                        "Entrez l'id de l'hôtel où se trouve la chambre → ",
                        1,
                        Long.MAX_VALUE
                );

                Hotel hotel = em.find(Hotel.class, hotelId);
                if (hotel == null) {
                    System.out.println("Il n'y a aucun hotel avec cette id.");
                    System.out.println(largeSeparator);
                    return;
                }

                bedroom.setHotel(hotel);

                // TODO: bedroom.setBooking();

                bedroom.setNumber(scUtils.getString(
                        "Entrez le nouveau numéro de la chambre → ",
                        false
                ));

                bedroom.setType(scUtils.getString(
                        "Entrez le nouveau type de la chambre → ",
                        false
                ));

                bedroom.setPrice(scUtils.getFloat(
                        "Entrez le nouveau prix de la chambre → ",
                        0,
                        Float.MAX_VALUE
                ));

                System.out.println(mediumSeparator);

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.merge(bedroom);
                transaction.commit();
                System.out.println("La chambre a été modifié avec succès.");
                System.out.println(largeSeparator);
            }
            case DELETE -> {
                long id = scUtils.getLong(
                        "Entrez l'id de la chambre à supprimer → ",
                        1,
                        Long.MAX_VALUE
                );

                Bedroom bedroom = em.find(Bedroom.class, id);
                if (bedroom == null) {
                    System.out.println("Cette id ne correspond à aucune chambre existante.");
                    System.out.println(largeSeparator);
                    return;
                }

                System.out.println(mediumSeparator);

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(bedroom);
                transaction.commit();
                System.out.println("La chambre a été supprimé avec succès.");
                System.out.println(largeSeparator);
            }
        }
    }

    private void treatHotel() {
        switch (actionType) {
            case CREATE -> {
                Hotel hotel = new Hotel();

                hotel.setName(scUtils.getString(
                        "Entrez le nom de l'hôtel → ",
                        false
                ));

                hotel.setAddress(scUtils.getString(
                        "Entrez l'adresse de l'hôtel → ",
                        false
                ));

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.persist(hotel);
                transaction.commit();
                System.out.println("L'hôtel a été crée avec succès.");
                System.out.println(largeSeparator);
            }
            case READ -> {
                String prompt = String.format("""
                        %s
                        1. Afficher tous les hôtels
                        2. Chercher un hôtel par nom
                        3. Chercher un hôtel par id
                        %s
                        → """,
                        largeSeparator, largeSeparator);

                int choice = scUtils.getInt(prompt, 1, 3);

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                List<Hotel> hotelList = new ArrayList<>();
                if (choice == 1) {
                    TypedQuery<Hotel> findAll = em.createNamedQuery("findAllHotel", Hotel.class);
                    hotelList.addAll(findAll.getResultList());
                } else if (choice == 2) {
                    String name = scUtils.getString(
                            "Entrez le nom de l'hôtel recherché → ",
                            false
                    );
                    TypedQuery<Hotel> findByName = em.createNamedQuery("findHotelByName", Hotel.class);
                    findByName.setParameter("name", name);
                    hotelList.addAll(findByName.getResultList());
                } else {
                    long id = scUtils.getLong(
                            "Entrez l'id de l'hôtel recherché → ",
                            1l,
                            Long.MAX_VALUE
                    );
                    Hotel hotel = em.find(Hotel.class, id);
                    if (hotel != null) {
                        hotelList.add(hotel);
                    }
                }
                transaction.commit();

                System.out.println(mediumSeparator);
                System.out.println("Résultat:");
                hotelList.stream().map(Hotel::toString).forEach(System.out::println);
                System.out.println(largeSeparator);
            }
            case UPDATE -> {
                long id = scUtils.getLong(
                        "Entrez l'id de l'hôtel à modifier → ",
                        1,
                        Long.MAX_VALUE
                );

                Hotel hotel = em.find(Hotel.class, id);
                if (hotel == null) {
                    System.out.println("Cette id ne correspond à aucun hôtel existant.");
                    System.out.println(largeSeparator);
                    return;
                }

                hotel.setName(scUtils.getString(
                        "Entrez le nouveau nom de l'hôtel → ",
                        false
                ));

                hotel.setAddress(scUtils.getString(
                        "Entrez la nouvelle adresse de l'hôtel → ",
                        false
                ));

                System.out.println(mediumSeparator);

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.merge(hotel);
                transaction.commit();
                System.out.println("L'hôtel a été modifié avec succès.");
                System.out.println(largeSeparator);
            }
            case DELETE -> {
                long id = scUtils.getLong(
                        "Entrez l'id de l'hôtel à supprimer → ",
                        1,
                        Long.MAX_VALUE
                );

                Hotel hotel = em.find(Hotel.class, id);
                if (hotel == null) {
                    System.out.println("Cette id ne correspond à aucun hôtel existant.");
                    System.out.println(largeSeparator);
                    return;
                }

                System.out.println(mediumSeparator);

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(hotel);
                transaction.commit();
                System.out.println("L'hôtel a été supprimé avec succès.");
                System.out.println(largeSeparator);
            }
        }
    }

    private void treatClient() {
        switch (actionType) {
            case CREATE -> {

            }
            case READ -> {

            }
            case UPDATE -> {

            }
            case DELETE -> {

            }
        }
    }

    private void treatBooking() {
        switch (actionType) {
            case CREATE -> {

            }
            case READ -> {

            }
            case UPDATE -> {

            }
            case DELETE -> {

            }
        }
    }

    private void treatService() {
        switch (actionType) {
            case CREATE -> {

            }
            case READ -> {

            }
            case UPDATE -> {

            }
            case DELETE -> {

            }
        }
    }

    private void treatEmployee() {
        switch (actionType) {
            case CREATE -> {
                Employee employee = new Employee();

                long hotelId = scUtils.getLong(
                        "Entrez l'id de l'hôtel où travail l'employé → ",
                        1,
                        Long.MAX_VALUE
                );

                Hotel hotel = em.find(Hotel.class, hotelId);
                if (hotel == null) {
                    System.out.println("Cette id ne correspond à aucun hôtel.");
                    System.out.println(largeSeparator);
                    return;
                }

                employee.setHotel(hotel);

                employee.setName(scUtils.getString(
                        "Entrez le nom de l'employé → ",
                        false
                ));

                employee.setFirstname(scUtils.getString(
                        "Entrez le prénom de l'employé → ",
                        false
                ));

                employee.setPost(scUtils.getString(
                        "Entrez le post occupé par l'employé → ",
                        false
                ));


                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.persist(employee);
                transaction.commit();
                System.out.println("L'employé a été crée avec succès.");
                System.out.println(largeSeparator);
            }
            case READ -> {
                String prompt = String.format("""
                        %s
                        1. Afficher tous les employee
                        2. Chercher un employé par nom complet
                        3. Chercher un employé par id
                        %s
                        → """,
                        largeSeparator, largeSeparator);

                int choice = scUtils.getInt(prompt, 1, 3);

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                List<Employee> employeeList = new ArrayList<>();
                if (choice == 1) {
                    TypedQuery<Employee> findAll = em.createNamedQuery("findAllEmployee", Employee.class);
                    employeeList.addAll(findAll.getResultList());
                } else if (choice == 2) {
                    String fullname = scUtils.getString(
                            "Entrez le nom complet de l'employé recherché (name firstname) → ",
                            false
                    ).trim();
                    TypedQuery<Employee> findByName = em.createNamedQuery("findEmployeeByFullName", Employee.class);
                    findByName.setParameter("fullname", fullname);
                    employeeList.addAll(findByName.getResultList());
                } else {
                    long id = scUtils.getLong(
                            "Entrez l'id de l'hôtel recherché → ",
                            1l,
                            Long.MAX_VALUE
                    );
                    Employee employee = em.find(Employee.class, id);
                    if (employee != null) {
                        employeeList.add(employee);
                    }
                }
                transaction.commit();

                System.out.println(mediumSeparator);
                System.out.println("Résultat:");
                employeeList.stream().map(Employee::toString).forEach(System.out::println);
                System.out.println(largeSeparator);
            }
            case UPDATE -> {
                long id = scUtils.getLong(
                        "Entrez l'id de l'employé à modifier → ",
                        1,
                        Long.MAX_VALUE
                );

                Employee employee = em.find(Employee.class, id);
                if (employee == null) {
                    System.out.println("Cette id ne correspond à aucun employé existant.");
                    System.out.println(largeSeparator);
                    return;
                }

                employee.setName(scUtils.getString(
                        "Entrez le nouveau nom de l'employé → ",
                        false
                ));

                employee.setFirstname(scUtils.getString(
                        "Entrez le nouveau prénom de l'employé → ",
                        false
                ));

                employee.setPost(scUtils.getString(
                        "Entrez le nouveau post occupé par l'employé → ",
                        false
                ));

                long hotelId = scUtils.getLong(
                        "Entrez l'id du nouvel hôtel où travail l'employé → ",
                        1,
                        Long.MAX_VALUE
                );

                Hotel hotel = em.find(Hotel.class, hotelId);
                if (hotel == null) {
                    System.out.println("Cette id ne correspond à aucun hôtel.");
                    System.out.println(largeSeparator);
                    return;
                }

                employee.setHotel(hotel);

                System.out.println(mediumSeparator);

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.merge(employee);
                transaction.commit();
                System.out.println("L'employé a été modifié avec succès.");
                System.out.println(largeSeparator);
            }
            case DELETE -> {
                long id = scUtils.getLong(
                        "Entrez l'id de l'employé à supprimer → ",
                        1,
                        Long.MAX_VALUE
                );

                Employee employee = em.find(Employee.class, id);
                if (employee == null) {
                    System.out.println("Cette id ne correspond à aucun employé existant.");
                    System.out.println(largeSeparator);
                    return;
                }

                System.out.println(mediumSeparator);

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(employee);
                transaction.commit();
                System.out.println("L'employé a été supprimé avec succès.");
                System.out.println(largeSeparator);
            }
        }
    }
}
