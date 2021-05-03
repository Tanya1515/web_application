import DAO_classes.DAO_client;
import entities.Client;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        //Employee_serv serv = new Employee_serv();

        //Employee new_emp = new Employee("Tanya", "Ozerova", "89536397040", "tanyaozerova13184@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2", "associate", 2);
        //serv.CreateEmployee(new_emp);
        //System.out.print(new_emp.getId_employee());

       //Contract contract_create = new Contract(17, 5, 1, java.sql.Date.valueOf("2011-01-01"), java.sql.Date.valueOf("2012-01-01"));

        //System.out.print(serv.CreateContract(contract_create));

//        Employee_serv serv = new Employee_serv();
//        List<Employee> l = serv.Emp_serv_client_date(7,3, java.sql.Date.valueOf("2011-10-01"), java.sql.Date.valueOf("2011-04-01"));
//        for ( Employee emp :l)
//        {
//            System.out.print(emp.getName());
//        }

//        Employee emp_1 = serv.findEmployee(1);
//        System.out.print(emp_1.getName());
//
        //System.out.print(serv.DeleteEmployee(10));
//
//        Employee emp_create = new Employee("Tanya", "Ozerova", "89636397038", "tanyaozerova@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2", "associate", 2);
//        System.out.print(serv.CreateEmployee(emp_create));

        //System.out.print(serv.UpdateEmployee(15, "Maria", "Tumanova", "89036554673", "tanyaozerova1318@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2", "associate", 2));
        DAO_client dao_client = new DAO_client();
        Client c = dao_client.findById(12);
        System.out.print(c.getName()) ;
//        Client_serv serv = new Client_serv();
//        List<Client> l = serv.Client_serv_emp_date(7,3, java.sql.Date.valueOf("2011-10-01"), java.sql.Date.valueOf("2011-04-01"));
//        for (Client c :l)
//        {
//            System.out.print(c.getName());
//        }
        //System.out.print(serv.UpdateClient(13, "Maria", "Tumanova", "89036554673", "tanyaozerova1318@gmail.com"));
        //Client cl_create = new Client("Tanya", "Ozerova", "89636397038", "tanyaozerova@gmail.com");
        //System.out.print(serv.CreateClient(cl_create));

        //Client cl_1 = serv.findClient(11);
        //System.out.print(cl_1.getName());

        //System.out.print(serv.DeleteClient(1));
    }
}




