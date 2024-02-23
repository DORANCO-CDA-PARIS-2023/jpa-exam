package main.java.com.doranco.entity;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Hotel")
    private Long idHotel;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Adresse")
    private String adresse;

    @Column(name = "NombreChambreDispo")
    private Integer nombreChambreDispo;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Chambre> chambres = new HashSet<>();

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Service> services = new HashSet<>();

    // Constructeur par défaut requis par Hibernate
    public Hotel() {
    }

    // Constructeur avec tous les champs
    public Hotel(String nom, String adresse, int nombreChambreDispo) {
        this.nom = nom;
        this.adresse = adresse;
        this.nombreChambreDispo = nombreChambreDispo;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getNombreChambreDispo() {
        return nombreChambreDispo;
    }

    public void setNombreChambreDispo(Integer nombreChambreDispo) {
        this.nombreChambreDispo = nombreChambreDispo;
    }

    public Set<Chambre> getChambres() {
        return chambres;
    }

    public void setChambres(Set<Chambre> chambres) {
        this.chambres = chambres;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
