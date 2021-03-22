package service;

import org.testng.Assert;
import org.testng.annotations.Test;
import entities.Contract;

public class Contract_servTest {

    @Test
    public void testFindContract() {
        Contract_serv serv = new Contract_serv();

        Contract new_contract = new Contract(15, 5, 3, java.sql.Date.valueOf("2011-01-01"), java.sql.Date.valueOf("2012-01-01"));
        serv.CreateContract(new_contract);

        Contract check_contract = serv.findContract(new_contract.getId_contract());
        Assert.assertEquals(new_contract.getId_contract(), check_contract.getId_contract());
        serv.DeleteContract(new_contract.getId_contract());
    }

    @Test
    public void testDeleteContract() {
        Contract_serv serv = new Contract_serv();
    }

    @Test
    public void testContract_serv_emp_date() {
        Contract_serv serv = new Contract_serv();
    }

    @Test
    public void testContract_serv_client_date() {
        Contract_serv serv = new Contract_serv();
    }

    @Test
    public void testCreateContract() {
        Contract_serv serv = new Contract_serv();
    }
}