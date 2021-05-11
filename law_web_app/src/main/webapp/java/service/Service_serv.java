package service;

import DAO_classes.DAO_service;
import entities.Contract;
import entities.Service;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Service_serv {

    private DAO_service dao_serv = new DAO_service();

    public List Service_client_emp (List <Contract> contracts) {

        List<Service> l = dao_serv.ListServices();
        List <Service> services = new ArrayList<>();
        for (Service serv : l)
        {
            int id_serv = serv.getId_service();
            for (Contract c : contracts) {
                if (c.getId_service() == id_serv) {
                    services.add(serv);
                }
            }
        }
        return services;
    }
}
