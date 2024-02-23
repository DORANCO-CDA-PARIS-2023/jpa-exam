package com.doranco;

import com.doranco.factory.UserFactory;
import com.doranco.factory.ModerateurFactory;

import java.time.LocalDate;

import com.doranco.entity.Hotel;
import com.doranco.entity.chambres.Chambre;
import com.doranco.entity.uers.Client;
import com.doranco.entity.uers.Moderateur;
import com.doranco.entity.uers.User;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App
{
    public static void main( String[] args )
    {
        try (EntityManagerFactory ef = Persistence.createEntityManagerFactory("TpFinal")){
//        	System.out.println("Entity manager factory closed"	);

        	Moderateur moderateur_1 = new Moderateur("Jean", "Dupont", "0123456789", "M", LocalDate.of(1980, 1, 1), new User("jdupont", "1234", "email", "moderateur"));
        	Moderateur moderateur_2 = new Moderateur("Jeanne", "Dupond", "0123456789", "F", LocalDate.of(1980, 1, 1), new User("jdupond", "1234", "email", "moderateur"));
        	Moderateur moderateur_3 = new Moderateur("Jeanne", "Dupond", "0123456789", "F", LocalDate.of(1980, 1, 1), new User("jdupond", "1234", "email", "moderateur"));
        	
        	Client client_1 = new Client("Jean", "Dupont", "0123456789", "M", LocalDate.of(1980, 1, 1), new User("jdupont", "1234", "email", "client"));
        	Client client_2 = new Client("Jeanne", "Dupond", "0123456789", "F", LocalDate.of(1980, 1, 1), new User("jdupond", "1234", "email", "client"));
        	Client client_3 = new Client("Jeanne", "Dupond", "0123456789", "F", LocalDate.of(1980, 1, 1), new User("jdupond", "1234", "email", "client"));
        	
        	Chambre chambre_1 = new Chambre("Chambre 1", 2, 100.0, new Hotel("Hotel 1"));
        	Chambre chambre_2 = new Chambre("Chambre 2", 2, 100.0, new Hotel("Hotel 1"));
        	Chambre chambre_3 = new Chambre("Chambre 3", 2, 100.0, new Hotel("Hotel 1"));
        		
        	
        	
        	
        	
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
