package com.doranco.entity;

import java.util.Date;

public class Reservation {

    private int id;
    private Date dateDebut;
    private Date datefin;
    private Date pay;
    private int montantPay;

    public Reservation() {
    }

    public Reservation(int id, Date dateDebut, Date datefin, Date pay, int montantPay) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.datefin = datefin;
        this.pay = pay;
        this.montantPay = montantPay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public Date getPay() {
        return pay;
    }

    public void setPay(Date pay) {
        this.pay = pay;
    }

    public int getMontantPay() {
        return montantPay;
    }

    public void setMontantPay(int montantPay) {
        this.montantPay = montantPay;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", datefin=" + datefin +
                ", pay=" + pay +
                ", montantPay=" + montantPay +
                '}';
    }
}
