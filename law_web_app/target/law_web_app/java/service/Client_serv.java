package service;

import entities.Client;
import DAO_classes.DAO_client;

public class Client_serv {

    private DAO_client dao_cl = new DAO_client();

    public Client_serv() {
    }

    public Client findClient(int id) {
        return dao_cl.findById(id);
    }

}
