package DAO_classes;

import entities.Contract;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class DAO_contractTest {

    @Test
    public void testDelete_ok() {
        DAO_contract dao_cont = new DAO_contract();
        Contract new_C = new Contract (9,1,7, java.sql.Date.valueOf("2014-01-01"), java.sql.Date.valueOf("2014-04-01"));

        dao_cont.save(new_C);
        Assert.assertEquals(dao_cont.delete(new_C), true);
    }

    @Test
    public void testDelete_not_ok() {
        DAO_contract dao_cont = new DAO_contract();
        Contract new_C = new Contract (9,1,7, java.sql.Date.valueOf("2014-01-01"), java.sql.Date.valueOf("2014-04-01"));
        dao_cont.save(new_C);
        dao_cont.delete(new_C);

        Assert.assertEquals(dao_cont.delete(new_C), false);

    }

    @Test
    public void testFindById_ok() {
        DAO_contract dao_cont = new DAO_contract();
        Contract new_C = new Contract (9,1,7, java.sql.Date.valueOf("2014-01-01"), java.sql.Date.valueOf("2014-04-01"));

        dao_cont.save(new_C);
        Assert.assertNotNull(dao_cont.findById(new_C.getId_contract()));
    }

    @Test
    public void testFindById_not_ok() {
        DAO_contract dao_cont = new DAO_contract();
        Contract new_C = new Contract (9,1,7, java.sql.Date.valueOf("2014-01-01"), java.sql.Date.valueOf("2014-04-01"));
        dao_cont.save(new_C);
        dao_cont.delete(new_C);
        Assert.assertNull(dao_cont.findById(new_C.getId_contract()));
    }

    @Test
    public void testListContract() {
        DAO_contract dao_cont = new DAO_contract();
        Contract new_C = new Contract (9,1,7, java.sql.Date.valueOf("2014-01-01"), java.sql.Date.valueOf("2014-04-01"));
        dao_cont.save(new_C);

        List<Contract> l = dao_cont.ListContract();
        for(Contract c: l)
        {
            Assert.assertNotNull(dao_cont.findById(new_C.getId_contract()));
        }
    }

    @Test
    public void testSave_ok() {
        DAO_contract dao_cont = new DAO_contract();
        Contract new_C = new Contract (9,1,7, java.sql.Date.valueOf("2014-01-01"), java.sql.Date.valueOf("2014-04-01"));

        Assert.assertEquals(dao_cont.save(new_C), true);
        dao_cont.delete(new_C);
    }

    @Test
    public void testSave_not_ok() {
        DAO_contract dao_cont = new DAO_contract();
        Contract new_C = new Contract (100,1,7, java.sql.Date.valueOf("2014-01-01"), java.sql.Date.valueOf("2014-04-01"));

        Assert.assertEquals(dao_cont.save(new_C), false);
    }
}