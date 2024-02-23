package com.doranco.service;

import java.util.List;

import com.doranco.entity.Client;
import com.doranco.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeeService {
    private final EntityManager manager;

    public EmployeeService(EntityManager manager)
    {
        this.manager = manager;
    }
    
    public void create(Employee employee)
    {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(employee);
        transaction.commit();
    }
    
    public List<Employee> findAll()
    {
        return manager
                .createQuery( "SELECT e FROM Employee e", Employee.class)
                .getResultList();
    }
    
    public void remove(int id) {
        EntityTransaction transaction = manager.getTransaction();
        Employee employee = manager.find(Employee.class, id);
        transaction.begin();
        manager.remove(employee);
        transaction.commit();
    }
    
    public Employee findById(int id) {
    	return manager.find(Employee.class, id);
    }
}
