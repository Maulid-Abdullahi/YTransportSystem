package schoolBus.model;

import customer.model.customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "commutesTrip")
public class commuteTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public List<studentInTrip> getStuds() {
        return studs;
    }

    public void setStuds(List<studentInTrip> studs) {
        this.studs = studs;
    }

    @OneToMany(mappedBy = "commuteTrips", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<studentInTrip> studs = new ArrayList<studentInTrip>();

    @OneToMany(mappedBy = "commuteTrips",cascade = CascadeType.ALL)
    private List<customer> cust = new ArrayList<customer>();

    @ManyToOne
    private commuteCompany bus;

    public List<customer> getCust() {
        return cust;
    }

    public void setCust(List<customer> cust) {
        this.cust = cust;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public commuteCompany getBus() {
        return bus;
    }

    public void setBus(commuteCompany bus) {
        this.bus = bus;
    }
}
