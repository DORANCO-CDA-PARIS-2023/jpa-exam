package com.doranco.jpaexam.service;


import com.doranco.jpaexam.model.EntityManagerTpFinal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceException;

import java.io.InputStream;
import java.util.Scanner;

public final class JpaExamCLI {

    private Scanner sc;

    public JpaExamCLI(InputStream is) {
        this.sc = new Scanner(is);
    }

    public int start() {
        EntityManagerFactory emf = null;
        try {
            emf = EntityManagerTpFinal.getINSTANCE().getEntityManagerFactory();
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            return 1;
        }

        try (EntityManager em = emf.createEntityManager()) {
            do {
                ActionType actionType = getActionType();
                DataType dataType = getDataType();
                ActionData actionData = new ActionData(actionType, dataType, sc, em);
                actionData.execute();
            } while (getContinue());
        }

        try {
            EntityManagerTpFinal.getINSTANCE().closeEntityManagerFactory();
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            return 1;
        }

        return 0;
    }

    private boolean getContinue() {
        String yesOrNot = null;

        do {
            System.out.print("Voulez-vous effectuer une nouvelle action (YES|NO) → ");
            try {
                String input = sc.nextLine().trim();
                if (input.equalsIgnoreCase("YES") || input.equalsIgnoreCase("NO")) {
                    yesOrNot = input;
                }
            } catch (IllegalArgumentException ignored) { }
        } while (yesOrNot == null);

        return yesOrNot.equalsIgnoreCase("yes");
    }

    private ActionType getActionType() {
        ActionType actionType = null;

        do {
            System.out.print("Entrez l'action que vous souhaitez effectuer (CREATE|READ|UPDATE|DELETE) → ");
            try {
                String input = sc.nextLine().trim();
                actionType = ActionType.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException ignored) { }
        } while (actionType == null);

        return actionType;
    }

    private DataType getDataType() {
        DataType dataType = null;

        do {
            System.out.print("Entrez le type de donnée que vous souhaitez manipuler " +
                    "(BEDROOM|BOOKING|CLIENT|EMPLOYEE|HOTEL|SERVICE) → ");
            try {
                String input = sc.nextLine().trim();
                dataType = DataType.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException ignored) { }
        } while (dataType == null);

        return dataType;
    }
}
