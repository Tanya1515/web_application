package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_client;

    private String name;
    private String surname;
    private String phone;
    private String e_mail;

    public Client() {
    }

    public Client(String name, String surname, String phone, String e_mail) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.e_mail = e_mail;
    }

    public int getId_client() {
        return id_client;
    }

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

}
//CREATE TABLE org.example.Client (
//    id_client serial PRIMARY KEY,
//    name varchar(50) NOT NULL,
//    surname varchar(50) NOT NULL,
//    phone char(11) NOT NULL UNIQUE,
//    e_mail text NOT NULL UNIQUE
//);