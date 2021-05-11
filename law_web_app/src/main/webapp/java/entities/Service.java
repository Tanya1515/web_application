package entities;

import javax.persistence.*;

@Entity
@Table(name = "Service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_service;

    private int  cost_of_service;
    private String name_of_service;

    public Service() {
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public String getName_of_service() {
        return name_of_service;
    }

    public void setName_of_service(String name_of_service) {
        this.name_of_service = name_of_service;
    }

    public int getCost_of_service() {
        return cost_of_service;
    }

    public void setCost_of_service(){
        this.cost_of_service = cost_of_service;
    }
}
