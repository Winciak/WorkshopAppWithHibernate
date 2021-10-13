package domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "service_ID")
    private Service service;

    @OneToMany(mappedBy = "order")
    private List<NumberOfParts> numberOfPartsList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<NumberOfParts> getNumberOfPartsList() {
        return numberOfPartsList;
    }

    public void setNumberOfPartsList(List<NumberOfParts> numberOfPartsList) {
        this.numberOfPartsList = numberOfPartsList;
    }
}
