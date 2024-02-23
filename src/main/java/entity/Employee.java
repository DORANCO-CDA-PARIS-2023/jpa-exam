package entity;
import jakarta.persistence.*;

@Entity
@Table
public final class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String firstname;
    private String post;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel")
    private Hotel hotel;

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}