package domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String brand;
    private String model;

    private java.sql.Date year;

    @ManyToOne
    @JoinColumn(name = "client_ID")
    private Client client;

    @OneToMany (mappedBy = "car")
    private List<Errand> errands;

    public List<Errand> getErrands() {
        return errands;
    }

    public void setErrands(List<Errand> errands) {
        this.errands = errands;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public java.sql.Date getYear() {
        return year;
    }

    public void setYear(java.sql.Date year) {
        this.year = year;
    }
}
