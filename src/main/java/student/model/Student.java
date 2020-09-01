package student.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import school.model.School;
import schoolBus.model.studentInTrip;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String regNo;


    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private School school;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private studentInTrip studentInTrip;

    public Student(int id, String name, String regNo) {
        this.id = id;
        this.name = name;
        this.regNo = regNo;

    }

    public Student() {
    }

    public Student(String name, String regNo) {
        this.name = name;
        this.regNo = regNo;

    }


    public Student(int id, String name, String regNo, String school, String studentInTrip) {
    }

    public Student(String name, String regNo, String school, String studentInTrip) {
    }


    public studentInTrip getStudentInTrip() {

        return studentInTrip;
    }

    public void setStudentInTrip(studentInTrip studentInTrip) {

        this.studentInTrip = studentInTrip;
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

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}



