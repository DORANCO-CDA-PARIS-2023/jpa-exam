package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public  final class Reservation {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @Column(nullable = false)
    @JoinColumn(name = "client", nullable = false)
    private Client client;
    @OneToMany(mappedBy = "Reservation", cascade = CascadeType.ALL)
    private List<Chambre> ChambreList;

    public Reservation() {
        this.ChambreList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Chambre> getChambreList() {
        return ChambreList;
    }

}