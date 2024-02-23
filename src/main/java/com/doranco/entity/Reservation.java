package com.doranco.entity;

import java.util.Date;

public class Reservation {
    private Client client;
    private Date startDate;
    private Date endDate;
    private Room room;

    public Reservation(Client client, Date startDate, Date endDate, Room room) {
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
