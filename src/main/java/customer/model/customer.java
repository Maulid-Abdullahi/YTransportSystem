package customer.model;
import schoolBus.model.commuteTrip;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private commuteTrip commuteTrips;

    @Column
    private String name;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public commuteTrip getCommuteTrips() {
        return commuteTrips;
    }

    public void setCommuteTrips(commuteTrip commuteTrips) {
        this.commuteTrips = commuteTrips;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
