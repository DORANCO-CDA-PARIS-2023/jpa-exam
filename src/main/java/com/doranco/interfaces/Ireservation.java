package com.doranco.interfaces;

import com.doranco.entity.Reservation;

public interface Ireservation extends Icrud<Reservation>{
    public Reservation findByDateDebut(String dateDebut);
    public Reservation findByDateFin(String dateFin);
    public Reservation findByClient(int idClient);
    public Reservation findByChambre(int idChambre);
} 
