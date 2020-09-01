package schoolBus.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "commutesCompany")
public class commuteCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String busNo;

    @OneToMany(mappedBy = "bus", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<commuteTrip> commuteTrips = new ArrayList<commuteTrip>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public List<commuteTrip> getCommuteTrips() {
        return commuteTrips;
    }

    public void setCommuteTrips(List<commuteTrip> commuteTrips) {
        this.commuteTrips = commuteTrips;
    }
}
