package service;

import entities.Contract;
import entities.Employee;
import org.testng.annotations.Test;

import org.testng.Assert;

import java.util.List;

public class Employee_servTest {

    @Test
    public void testFindEmployee() {
        Employee_serv serv = new Employee_serv();

        Employee new_emp = new Employee("Tanya", "Ozerova", "89446397038", "tanyaozerova11@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2", "associate", 2);
        serv.CreateEmployee(new_emp);

        Employee check_emp = serv.findEmployee(new_emp.getId_employee());

        Assert.assertEquals(new_emp.getId_employee(), check_emp.getId_employee());
        serv.DeleteEmployee(new_emp.getId_employee());
    }

    @Test
    public void testDeleteEmployee() {

        Employee_serv serv = new Employee_serv();

        Employee new_emp = new Employee("Tanya", "Ozerova", "89446397038", "tanyaozerova11@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2", "associate", 2);
        serv.CreateEmployee(new_emp);
        Assert.assertEquals(serv.EmployeeEqual(new_emp), true);

        serv.DeleteEmployee(new_emp.getId_employee());
        Assert.assertNull(serv.findEmployee(new_emp.getId_employee()));
    }

    @Test
    public void testCreateEmployee() {
        Employee_serv serv = new Employee_serv();

        Employee new_emp = new Employee("Tanya", "Ozerova", "89446397038", "tanyaozerova11@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2", "associate", 2);
        serv.CreateEmployee(new_emp);

        Assert.assertEquals(serv.EmployeeEqual(new_emp), true);
        serv.DeleteEmployee(new_emp.getId_employee());
    }

    @Test
    public void testUpdateEmployee() {

        Employee_serv serv = new Employee_serv();
        Employee new_emp = new Employee("Tanya", "Ozerova", "89446397038", "tanyaozerova11@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2", "associate", 2);
        serv.CreateEmployee(new_emp);

        Assert.assertEquals(serv.EmployeeEqual(new_emp), true);

        serv.UpdateEmployee(new_emp.getId_employee(), "Maria", "Tumanova", "89016554673", "tanyaozerova318@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2", "associate", 2);
        Assert.assertEquals(serv.EmployeeEqual(new_emp), false);
        serv.DeleteEmployee(new_emp.getId_employee());
    }

    @Test
    public void testEmp_serv_client_date() {

        Contract_serv serv = new Contract_serv();
        Employee_serv serv_emp = new Employee_serv();

        Contract new_C = new Contract(9,1,7, java.sql.Date.valueOf("2014-01-01"), java.sql.Date.valueOf("2014-04-01"));
        serv.CreateContract(new_C);

        List<Employee> emps = serv_emp.Emp_serv_client_date(new_C.getId_service(), new_C.getId_client(), java.sql.Date.valueOf("2011-10-01"), java.sql.Date.valueOf("2015-04-01"));
        for (Employee emp:emps)
        {
            Assert.assertEquals(serv_emp.EmployeeEqual(emp), true);
        }
        serv.DeleteContract(new_C.getId_contract());
    }
}