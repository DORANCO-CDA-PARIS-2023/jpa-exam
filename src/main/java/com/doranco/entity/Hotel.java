package com.doranco.entity;

import java.util.ArrayList;
import java.util.List;

import com.doranco.entity.chambres.Chambre;
import com.doranco.entity.uers.Address;
import com.doranco.entity.uers.Client;
import com.doranco.entity.uers.Moderateur;

import jakarta.persistence.*;

@Entity
@Table(name="hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Chambre> chambres;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Client> clients;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Moderateur> moderateurs;

    public Hotel() {
        this.chambres = new ArrayList<Chambre>();
        this.clients = new ArrayList<Client>();
        this.moderateurs = new ArrayList<Moderateur>();
    }

    public Hotel(String name, String phone, String email, Address address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.chambres = new ArrayList<Chambre>();
        this.clients = new ArrayList<Client>();
        this.moderateurs = new ArrayList<Moderateur>();
    }

    public Hotel(Long id, String name, String phone, String email, Address address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.chambres = new ArrayList<Chambre>();
        this.clients = new ArrayList<Client>();
        this.moderateurs = new ArrayList<Moderateur>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Chambre> getChambres() {
        return chambres;
    }

    public void setChambres(List<Chambre> chambres) {
        this.chambres = chambres;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Moderateur> getModerateurs() {
        return moderateurs;
    }

    public void setModerateurs(List<Moderateur> moderateurs) {
        this.moderateurs = moderateurs;
    }

    @Override
    public String toString() {
        return "Hotel [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address=" + address.toString()
                + "]";
    }
}
