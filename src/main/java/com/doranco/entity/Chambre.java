package main.java.com.doranco.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Chambre")
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Chambre")
    private Long idChambre;

    @Column(name = "Numero")
    private String numero;

    @Column(name = "Type")
    private String type;

    @Column(name = "Prix")
    private float prix;

    @ManyToOne
    @JoinColumn(name = "ID_Hotel", nullable = false)
    private Hotel hotel;

    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @Transient
    private EntityManager entityManager;

    public Chambre() {
    }

    public Chambre(String numero, String type, float prix, Hotel hotel) {
        this.numero = numero;
        this.type = type;
        this.prix = prix;
        this.hotel = hotel;
    }

    public Long getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Long idChambre) {
        this.idChambre = idChambre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void ajouterChambre(String numero, String type, float prix, Hotel hotel) {

        if (entityManager != null) {
            entityManager.getTransaction().begin();
            Chambre chambre = new Chambre(numero, type, prix, hotel);
            entityManager.persist(chambre);
            entityManager.getTransaction().commit();
        } else {
            throw new IllegalStateException("EntityManager non initialisé. Veuillez le définir avant d'utiliser cette méthode.");
        }
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
