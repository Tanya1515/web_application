package DAO_classes;

import entities.Client;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.Client_serv;

public class DAO_clientTest {

    @Test
    public void testDelete_ok() {
        DAO_client dao_cl = new DAO_client();
        Client new_client = new Client("Tanya", "Ozerova", "09636397001", "yaozea11@gmail.com");
        dao_cl.save(new_client);

        Assert.assertEquals(dao_cl.delete(new_client), true);
    }

    @Test
    public void testDelete_not_ok() {
        DAO_client dao_cl = new DAO_client();
        Client new_client = new Client("Tanya", "Ozerova", "89636397000", "tanyaozea@gmail.com");
        dao_cl.save(new_client);
        dao_cl.delete(new_client);

        Assert.assertEquals(dao_cl.delete(new_client), false);
    }

    @Test
    public void testFindById_ok() {
        DAO_client dao_cl = new DAO_client();
        Client new_client = new Client("Tanya", "Ozerova", "89636337000", "yzova@gmail.com");
        dao_cl.save(new_client);

        Assert.assertNotNull(dao_cl.findById(new_client.getId()));
        dao_cl.delete(new_client);
    }

    @Test
    public void testFindById_not_ok() {
        DAO_client dao_cl = new DAO_client();
        Client new_client = new Client("Tanya", "Ozerova", "89637797000", null);
        dao_cl.save(new_client);

        dao_cl.delete(new_client);
        Assert.assertEquals(dao_cl.findById(new_client.getId()), null);
    }

    @Test
    public void testSave_ok() {
        DAO_client dao_cl = new DAO_client();
        Client new_client = new Client("Tanya", "Ozerova", "99636397001", "rraynyaoz11a@gmail.com");

        Assert.assertEquals(dao_cl.save(new_client), true);
        dao_cl.delete(new_client);
    }

    @Test
    public void testSave_not_ok() {
        Client_serv serv = new Client_serv();
        DAO_client dao_cl = new DAO_client();
        Client new_client = new Client("Tanya", "Ozerova", "89636397039", null);

        Assert.assertEquals(dao_cl.save(new_client), false);
    }

    @Test
    public void testUpdate_ok() {
        DAO_client dao_cl = new DAO_client();
        Client new_client = new Client("Tanya", "Ozerova", "89336397001", "tany11a@gmail.com");
        dao_cl.save(new_client);

        new_client.setSurname("Lazaareva");
        Assert.assertEquals( dao_cl.update(new_client), true);

        dao_cl.delete(new_client);
    }

    @Test
    public void testUpdate_not_ok() {
        DAO_client dao_cl = new DAO_client();
        Client new_client = new Client("Tanya", "Ozerova", "89636397039", "tanyaozerova@gmail.com");
        dao_cl.save(new_client);
        dao_cl.delete(new_client);

        Client new_client_up = new Client("Tanya", "Ozerova", "89636397039", "tanyaozerova@gmail.com");
        Assert.assertEquals( dao_cl.update(new_client_up), false);
    }
}