package service;

import org.testng.Assert;
import org.testng.annotations.Test;
import entities.Contract;

import java.util.List;

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

        Contract new_contract = new Contract (12,7,3, java.sql.Date.valueOf("2011-01-01"), java.sql.Date.valueOf("2011-04-01"));
        serv.CreateContract(new_contract);

        Assert.assertEquals(serv.ContractEqual(new_contract), true);

        serv.DeleteContract(new_contract.getId_contract());

        Assert.assertNull(serv.findContract(new_contract.getId_client()));
    }

    @Test
    public void testContract_serv_emp_date() {

        Contract_serv serv = new Contract_serv();

        Contract new_C = new Contract (9,1,7, java.sql.Date.valueOf("2014-01-01"), java.sql.Date.valueOf("2014-04-01"));
        serv.CreateContract(new_C);

        List<Contract> contracts = serv.Contract_serv_emp_date(new_C.getId_service(), new_C.getId_employee(), java.sql.Date.valueOf("2011-10-01"), java.sql.Date.valueOf("2015-04-01"));
        for (Contract c:contracts)
        {
            Assert.assertEquals(serv.ContractEqual(c), true);
        }
        serv.DeleteContract(new_C.getId_contract());
    }

    @Test
    public void testContract_serv_client_date() {

        Contract_serv serv = new Contract_serv();

        Contract new_C = new Contract (9,1,7, java.sql.Date.valueOf("2014-01-01"), java.sql.Date.valueOf("2014-04-01"));
        serv.CreateContract(new_C);

        List<Contract> contracts = serv.Contract_serv_client_date(new_C.getId_service(), new_C.getId_client(), java.sql.Date.valueOf("2011-10-01"), java.sql.Date.valueOf("2015-04-01"));
        for (Contract c:contracts)
        {
            Assert.assertEquals(serv.ContractEqual(c), true);
        }
        serv.DeleteContract(new_C.getId_contract());
    }

    @Test
    public void testCreateContract() {

        Contract_serv serv = new Contract_serv();

        Contract new_Contract = new Contract (12,7,3, java.sql.Date.valueOf("2011-01-01"), java.sql.Date.valueOf("2011-04-01"));
        serv.CreateContract(new_Contract);

        Assert.assertEquals(serv.ContractEqual(new_Contract), true);
        serv.DeleteContract(new_Contract.getId_contract());
    }
}