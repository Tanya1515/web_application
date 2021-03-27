package entities;

import javax.persistence.*;

@Entity
@Table(name = "Contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_contract;

    private int id_employee;
    private int id_service;
    private int id_client;
    private String date_of_begining;
    private String date_of_end;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_employee")
    private Employee emp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_service")
    private Service serv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private entities.Client client;

    public Contract() {
    }

    public Contract(int id_employee, int id_service, int id_client, String date_of_begining, String date_of_end) {
        this.id_employee = id_employee;
        this.id_service = id_service;
        this.id_client = id_client;
        this.date_of_begining = date_of_begining;
        this.date_of_end = date_of_end;
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

    public String getDate_of_begining() {
        return date_of_begining;
    }

    public void setDate_of_begining(String date_of_begining) {
        this.date_of_begining = date_of_begining;
    }

    public String getDate_of_end() {
        return date_of_end;
    }

    public void setDate_of_end(String date_of_end) {
        this.date_of_end = date_of_end;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Service getServ() {
        return serv;
    }

    public void setServ(Service serv) {
        this.serv = serv;
    }

    public entities.Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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