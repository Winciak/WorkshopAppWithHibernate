package domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int area;

    @OneToMany(mappedBy = "hall")
    private List<Errand> errands;

    @OneToMany(mappedBy = "hall")
    private List<Employee> employees;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public List<Errand> getErrands() {
        return errands;
    }

    public void setErrands(List<Errand> errands) {
        this.errands = errands;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
