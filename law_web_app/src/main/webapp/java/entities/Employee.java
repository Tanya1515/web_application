package entities;

import javax.persistence.*;


@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_employee")
    private int id_employee;

    private String name;
    private String surname;
    private String phone;
    private String e_mail;
    private String education;
    private String home_address;
    private String position;
    private int work_experience;

    public Employee() {
    }

    public Employee(String name, String surname, String phone, String e_mail, String education, String home_address, String position, int work_experience) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.e_mail = e_mail;
        this.education = education;
        this.home_address = home_address;
        this.position = position;
        this.work_experience = work_experience;
    }


    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id) { this.id_employee = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getWork_experience() {
        return work_experience;
    }

    public void setWork_experience(int work_experience) {
        this.work_experience = work_experience;
    }

}
//CREATE TABLE org.example.Employee (
//    id_employee serial PRIMARY KEY,
//    name varchar(50) NOT NULL,
//    surname varchar(50) NOT NULL,
//    phone char(11) NOT NULL UNIQUE,
//    e_mail text NOT NULL UNIQUE,
//    education varchar(50) NOT NULL,
//    home_address varchar(50),
//    position  varchar(50) NOT NULL,
//    CHECK(position IN ('paralegal', 'associate', 'senior_associate', 'partner', 'legal_advisor', 'lawyer')),
//    work_experience integer NOT NULL
//);