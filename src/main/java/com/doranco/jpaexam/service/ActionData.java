package com.doranco.jpaexam.service;

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

            }
            case READ -> {

            }
            case UPDATE -> {

            }
            case DELETE -> {

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
                    TypedQuery<Hotel> findAll = em.createNamedQuery("findAll", Hotel.class);
                    hotelList.addAll(findAll.getResultList());
                } else if (choice == 2) {
                    String name = scUtils.getString(
                            "Entrez le nom de l'hôtel recherché → ",
                            false
                    );
                    TypedQuery<Hotel> findByName = em.createNamedQuery("findByName", Hotel.class);
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

            }
            case READ -> {

            }
            case UPDATE -> {

            }
            case DELETE -> {

            }
        }
    }
}
