package domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String part_name;
    private String part_type;
    private String part_version;

    private BigDecimal part_price;

    @ManyToOne
    private NumberOfParts numberOfParts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public String getPart_type() {
        return part_type;
    }

    public void setPart_type(String part_type) {
        this.part_type = part_type;
    }

    public String getPart_version() {
        return part_version;
    }

    public void setPart_version(String part_version) {
        this.part_version = part_version;
    }

    public BigDecimal getPart_price() {
        return part_price;
    }

    public void setPart_price(BigDecimal part_price) {
        this.part_price = part_price;
    }

    public NumberOfParts getNumberOfParts() {
        return numberOfParts;
    }

    public void setNumberOfParts(NumberOfParts numberOfParts) {
        this.numberOfParts = numberOfParts;
    }
}
