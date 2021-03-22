package service;

import entities.Employee;
import org.testng.annotations.Test;

import org.testng.Assert;

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
    }

    @Test
    public void testCreateEmployee() {
        Employee_serv serv = new Employee_serv();

        Employee new_emp = new Employee("Tanya", "Ozerova", "89536367039", "tanyaozerva19@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2", "associate", 2);
        serv.CreateEmployee(new_emp);


        Employee check_emp = serv.findEmployee(new_emp.getId_employee());

        Assert.assertEquals(new_emp.getId_employee(), check_emp.getId_employee());
        Assert.assertEquals(new_emp.getE_mail(), check_emp.getE_mail());
        Assert.assertEquals(new_emp.getPhone(), check_emp.getPhone());
        Assert.assertEquals(new_emp.getName(), check_emp.getName());
        Assert.assertEquals(new_emp.getSurname(), check_emp.getSurname());
        Assert.assertEquals(new_emp.getHome_address(), check_emp.getHome_address());
        Assert.assertEquals(new_emp.getEducation(), check_emp.getEducation());
        Assert.assertEquals(new_emp.getPosition(), check_emp.getPosition());
        Assert.assertEquals(new_emp.getWork_experience(), check_emp.getWork_experience());

        serv.DeleteEmployee(new_emp.getId_employee());
    }

    @Test
    public void testUpdateEmployee() {
        Employee_serv serv = new Employee_serv();
    }

    @Test
    public void testEmp_serv_client_date() {
        Employee_serv serv = new Employee_serv();
    }
}