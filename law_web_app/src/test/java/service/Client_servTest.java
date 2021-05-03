package service;

import entities.Client;
import entities.Contract;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;


public class Client_servTest {

    @Test
    public void testFindClient() {
        Client_serv serv = new Client_serv();

        Client new_client = new Client("Tanya", "Ozerova", "33333333333", "tany444@gmail.com");
        serv.CreateClient(new_client);

        Client check_contract = serv.findClient(new_client.getId());
        Assert.assertEquals(new_client.getId(), check_contract.getId());
        serv.DeleteClient(new_client.getId());
    }

    @Test
    public void testDeleteClient() {

        Client_serv serv = new Client_serv();

        Client new_client = new Client("Tanya", "Ozerova", "89175307098", "tanya33@gmail.com");
        serv.CreateClient(new_client);

        Assert.assertEquals(serv.ClientEqual(new_client), true);

        serv.DeleteClient(new_client.getId());

        Assert.assertNull(serv.findClient(new_client.getId()));
    }

    @Test
    public void testCreateClient() {

        Client_serv serv = new Client_serv();

        Client new_client = new Client("Tanya", "Ozerova", "89175307098", "tanya33@gmail.com");
        serv.CreateClient(new_client);

        Assert.assertEquals(serv.ClientEqual(new_client), true);
        serv.DeleteClient(new_client.getId());
    }

    @Test
    public void testUpdateClient() {

        Client_serv serv = new Client_serv();

        Client new_client = new Client("Tanya", "Ozerova", "89175307098", "tanya33@gmail.com");
        serv.CreateClient(new_client);

        Assert.assertEquals(serv.ClientEqual(new_client), true);

        serv.UpdateClient(new_client.getId(), "Maria", "Tumanova", "89036554673", "tanyaozerova1318@gmail.com");
        Assert.assertEquals(serv.ClientEqual(new_client), false);
        serv.DeleteClient(new_client.getId());
    }

    @Test
    public void testClient_serv_emp_date() {

        Contract_serv serv = new Contract_serv();
        Client_serv serv_client = new Client_serv();


        Contract new_C = new Contract (9,1,7, java.sql.Date.valueOf("2014-01-01"), java.sql.Date.valueOf("2014-04-01"));
        Contract new_с = new Contract (9,1,12, java.sql.Date.valueOf("2014-01-01"), java.sql.Date.valueOf("2014-04-01"));
        serv.CreateContract(new_C);
        serv.CreateContract(new_с);


        List<Client> clients = serv_client.Client_serv_emp_date(new_C.getId_service(), new_C.getId_employee(), java.sql.Date.valueOf("2011-10-01"), java.sql.Date.valueOf("2015-04-01"));
        for (Client c:clients)
        {
            Assert.assertEquals(serv_client.ClientEqual(c), true);
        }
        serv.DeleteContract(new_C.getId_contract());
        serv.DeleteContract(new_с.getId_contract());
    }
}