package com.doranco;


import java.util.List;

import entity.Customer;
import entity.Hotel;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import service.CustomerService;
import service.HotelService;

public class AppCustomer
{
    public static void main( String[] args )
    {
    try (var ef = Persistence.createEntityManagerFactory("finalTP")) {
        var manager = ef.createEntityManager();

        	 CustomerService service = new CustomerService(manager);

             service.create(new Customer("mourad", "paul" ,  " 22 rue bapst Paris 75000", "+332345777" ));
            service.create(new Customer("walid", "paul" ,  " 22 rue bapst madrid 75000", "+332995678" ));
             service.create(new Customer("amelie", "aaaaa" ,  " 22 rue bapst nolden 75000", "+332005678" ));
             service.create(new Customer("sizar", "soche" ,  " 22 rue bapst milan 75000", "+332334678" ));

             List<Customer> Customers = service.findByName("mourad");
             for (Customer customer : Customers)
           {
                 System.out.println(customer);
             }

             manager.close();
         }
    
    
        try (var ef = Persistence.createEntityManagerFactory("finalTP")) {
            var manager = ef.createEntityManager();

            	

            	 CustomerService service = new CustomerService(manager);
            	    
            	  manager.getTransaction().begin();
            	    
            	    
            	    int idCustomer = 1;
            	    service.remove(idCustomer);
            	    
            	    manager.getTransaction().commit();

            	    manager.close();
     }
 }
}
     






