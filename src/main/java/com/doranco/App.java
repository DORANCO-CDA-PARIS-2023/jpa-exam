package com.doranco;


import com.doranco.cli.CommandLineInterface;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App
{
    public static void main( String[] args )
    {
        try (EntityManagerFactory ef = Persistence.createEntityManagerFactory("TpFinal")){
        	CommandLineInterface cli = new CommandLineInterface("TpFinal");
            cli.start();

        }
    }
}
