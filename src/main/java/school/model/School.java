package school.model;

import student.model.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "school")
public class School {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column
    private String name;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column
    private String email;
    @OneToMany(mappedBy = "school",  cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<Student>();


    public School( String name, String phoneNo, String email) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public School() {
    }

    public School(int id, String name, String phoneNo, String email) {
    }

    public School(int id, String name, String phoneNo, String email, String students) {
    }

    public School(String name, String phoneNo, String email, String students) {
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> Students) {
        this.students = Students;
    }


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
