package service;

import entities.Client;
import org.testng.annotations.Test;
import org.testng.Assert;


public class Client_servTest {

    @Test
    public void testFindClient() {
        Client_serv serv = new Client_serv();

        Client new_client = new Client("Tanya", "Ozerova", "89636397039", "tanyaozerova@gmail.com");
        serv.CreateClient(new_client);

        Client check_contract = serv.findClient(new_client.getId_client());
        Assert.assertEquals(new_client.getId_client(), check_contract.getId_client());
        serv.DeleteClient(new_client.getId_client());
    }

    @Test
    public void testDeleteClient() {
        Client_serv serv = new Client_serv();
    }

    @Test
    public void testCreateClient() {
        Client_serv serv = new Client_serv();
    }

    @Test
    public void testUpdateClient() {
        Client_serv serv = new Client_serv();
    }

    @Test
    public void testClient_serv_emp_date() {
        Client_serv serv = new Client_serv();
    }
}