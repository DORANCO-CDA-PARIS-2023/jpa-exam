package com.doranco;


import com.doranco.entity.Chambre;
import com.doranco.entity.Client;
import com.doranco.entity.Reservation;
import com.doranco.services.ReservationCommandLine;
import com.doranco.services.ReservationService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        try (EntityManagerFactory ef = Persistence.createEntityManagerFactory("TpFinal")){
            EntityManager manager = ef.createEntityManager();

            ReservationService service = new ReservationService(manager);

            Client client1 = new Client("BELIN","Maxime","10 rue Doranco","maxime@mail.com");
            Client client2 = new Client("TITI","Toto","15 rue toto","toto.t@mail.com");


            Chambre chambre1 = new Chambre(001,"Classique",29.99,"Disponible");
            Chambre chambre2 = new Chambre(002,"Grande suite",79.99,"Disponible");


            EntityTransaction transaction = manager.getTransaction();
            transaction.begin();

            manager.persist(client1);
            manager.persist(client2);

            manager.persist(chambre1);
            manager.persist(chambre2);


           transaction.commit();

           System.out.println(client1);
           System.out.println(chambre1);

            service.create(new Reservation("01.01.2024","03.01.2024","en cours de validation",client1,chambre1));
            service.create(new Reservation("05.01.2024","08.01.2024","en cours de validation",client1,chambre2));
            service.create(new Reservation("09.01.2024","10.01.2024","en cours de validation",client2,chambre2));


            ReservationCommandLine reservationCommandLine = new ReservationCommandLine();
            reservationCommandLine.start();


           manager.close();
        }
    }
}
