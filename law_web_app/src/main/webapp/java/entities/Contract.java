package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_contract;

    private int id_employee;
    private int id_service;
    private int id_client;
    private Date date_of__begining;
    private Date date_of__end;

    public Contract() {
    }

    public Contract(int id_employee, int id_service, int id_client, Date date_of_begining, Date date_of_end) {
        this.id_employee = id_employee;
        this.id_service = id_service;
        this.id_client = id_client;
        this.date_of__begining = date_of_begining;
        this.date_of__end = date_of_end;
    }


    public int getId_contract() {
        return id_contract;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public Date getDate_of_begining() {
        return date_of__begining;
    }

    public void setDate_of_begining(Date date_of__begining) {
        this.date_of__begining = date_of__begining;
    }

    public Date getDate_of_end() {
        return date_of__end;
    }

    public void setDate_of_end(Date date_of__end) {
        this.date_of__end = date_of__end;
    }

}
//CREATE TABLE org.example.Contract(
//    id_contract serial PRIMARY KEY,
//    id_employee integer REFERENCES org.example.Employee (id_employee) ON DELETE CASCADE,
//    id_service integer REFERENCES org.example.Service (id_service) ON DELETE CASCADE,
//    id_client integer REFERENCES org.example.Client (id_client) ON DELETE CASCADE,
//    date_of__begining date NOT NULL,
//    date_of__end date NOT NULL,
//    CHECK (date_of__end > date_of__begining)
//);