package com.doranco.entity;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private String address;
    private int totalRooms;
    private List<Room> rooms;

    public Hotel(String name, String address, int totalRooms) {
        this.name = name;
        this.address = address;
        this.totalRooms = totalRooms;
        this.rooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
