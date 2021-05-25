package web_test;

import DAO_classes.DAO_client;
import DAO_classes.DAO_employee;
import entities.Client;
import entities.Contract;
import entities.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class web_test {

    protected final String appURL = "http://localhost:8080/greeting";
    protected WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        final String safariDriverPath = "/usr/bin/safaridriver";  // "/usr/bin/google-chrome";
        System.setProperty("webdriver.safari.driver", safariDriverPath);

        driver = new SafariDriver();
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1000, 1000));
        driver.manage().timeouts().implicitlyWait(10, SECONDS);

        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().pageLoadTimeout(10, SECONDS);
    }

   void Check_clients(Client new_client, Client check_client){
       Assert.assertEquals(new_client.getName(),check_client.getName());
       Assert.assertEquals(new_client.getSurname(), check_client.getSurname());
       Assert.assertEquals(new_client.getE_mail(), check_client.getE_mail());
       Assert.assertEquals(new_client.getPhone(), check_client.getPhone());
    }

    @Test()
    public void Client_CreateDeleteUpdateServ_Test(){
        Client new_client = new Client("Tanya", "Ozerova", "8999999999 ", "tanyaozerova1318@gmail.com");

        driver.get(appURL);
        WebElement button = wait.until(visibilityOfElementLocated(By.id("all_clients_button")));
        Assert.assertEquals(driver.getTitle(), "Hello web app");

        //переход на страницу клиентов
        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("new_client_button")));
        Assert.assertEquals(driver.getTitle(), "Main client");

        //переход на страницу создания нового клинета
        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("create_client_button")));
        Assert.assertEquals(driver.getTitle(), "New client");

        //добавление нового клиента
        driver.findElement(By.id("name")).sendKeys(new_client.getName());
        driver.findElement(By.id("surname")).sendKeys(new_client.getSurname());
        driver.findElement(By.id("phone")).sendKeys(new_client.getPhone());
        driver.findElement(By.id("e_mail")).sendKeys(new_client.getE_mail());

        DAO_client dao_client = new DAO_client();
        List<Client> l = dao_client.ListClient ();
        int max_id = 0;
        for (Client cl : l)
            if (cl.getId()>max_id)
                max_id = cl.getId();

        //проверка, что клиент добавлен корректно
        String id_new = "//a[@href='/client/" + max_id + "']" ;
        String id = "//a[@href='/client/" + "171" + "']" ;

        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.xpath(id_new)));
        Assert.assertEquals(driver.getTitle(), "Main client");


        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("save_client_button")));
        Client check_client = new Client();
        check_client.setName(driver.findElement(By.id("name")).getAttribute("value"));
        check_client.setSurname(driver.findElement(By.id("surname")).getAttribute("value"));
        check_client.setPhone(driver.findElement(By.id("phone")).getAttribute("value"));
        check_client.setE_mail(driver.findElement(By.id("e_mail")).getAttribute("value"));

        Assert.assertEquals(driver.getTitle(), "Update client");

        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.xpath(id_new)));
        Assert.assertEquals(driver.getTitle(), "Main client");
        Check_clients(new_client, check_client);

        //изменеиние информации о клиенте
        new_client.setName("Anna");
        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("save_client_button")));
        Assert.assertEquals(driver.getTitle(), "Update client");

        driver.findElement(By.id("name")).sendKeys(new_client.getName());
        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.xpath(id_new)));
        Assert.assertEquals(driver.getTitle(), "Main client");

        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("save_client_button")));
        Assert.assertEquals(driver.getTitle(), "Update client");

        check_client.setName(driver.findElement(By.id("name")).getAttribute("value"));
        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.xpath(id)));
        Assert.assertEquals(driver.getTitle(), "Main client");
        Check_clients(new_client, check_client);

        //услуги существующего клиента
        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("serv_button")));
        Assert.assertEquals(driver.getTitle(), "Update client");
        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("all_clients_button")));
        Assert.assertEquals(driver.getTitle(), "Serv for client");

        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.xpath(id_new)));
        Assert.assertEquals(driver.getTitle(), "Main client");

        //удаление нового клиента
        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("delete_button")));
        Assert.assertEquals(driver.getTitle(), "Update client");
        button.click();
        wait.until(stalenessOf(button));
        Assert.assertEquals(driver.getTitle(), "Main client");

    }

    void Check_emps(Employee new_emp, Employee check_emp){
        Assert.assertEquals(new_emp.getName(),check_emp.getName());
        Assert.assertEquals(new_emp.getSurname(), check_emp.getSurname());
        Assert.assertEquals(new_emp.getE_mail(), check_emp.getE_mail());
        Assert.assertEquals(new_emp.getPhone(), check_emp.getPhone());
        Assert.assertEquals(new_emp.getPosition(),check_emp.getPosition());
        Assert.assertEquals(new_emp.getEducation(), check_emp.getEducation());
        Assert.assertEquals(new_emp.getHome_address(), check_emp.getHome_address());
        Assert.assertEquals(new_emp.getWork_experience(), check_emp.getWork_experience());
    }

    @Test()
    public void Emp_CreateDeleteUpdateServ_Test(){
        Employee new_emp = new Employee("Igor", "Veremchuk", "8499999999", "igormemmory@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2",  "associate", 2);

        driver.get(appURL);
        //Assert.assertEquals(driver.getTitle(), "Hello web app");

        driver.findElement(By.id("all_emps_button")).click();
        //Assert.assertEquals(driver.getTitle(), "Main emp");

        driver.findElement(By.id("new_emp_button")).click();
        //Assert.assertEquals(driver.getTitle(), "New emp");

        driver.findElement(By.id("name")).sendKeys(new_emp.getName());
        driver.findElement(By.id("surname")).sendKeys(new_emp.getSurname());
        driver.findElement(By.id("phone")).sendKeys(new_emp.getPhone());
        driver.findElement(By.id("e_mail")).sendKeys(new_emp.getE_mail());
        driver.findElement(By.id("education")).sendKeys(new_emp.getEducation());
        driver.findElement(By.id("home_address")).sendKeys(new_emp.getHome_address());
        driver.findElement(By.id("position")).sendKeys(new_emp.getPosition());
        Select work_exp = new Select(driver.findElement(By.name("work_experience")));
        work_exp.selectByVisibleText(new_emp.getWork_experience().toString());
        driver.findElement(By.id("create_emp_button")).click();
        //Assert.assertEquals(driver.getTitle(), "Main emp");

        DAO_employee dao_emp = new DAO_employee();
        List<Employee> l = dao_emp.ListEmp ();
        int max_id = 0;
        for (Employee emp : l)
            if (emp.getId_employee()>max_id)
                max_id = emp.getId_employee();

        //проверка корректности добавления нового работника
        String id_new = "//a[@href='/emp/" + max_id + "']" ;

        driver.findElement(By.xpath(id_new)).click();
        Employee check_emp = new Employee();
        check_emp.setName(driver.findElement(By.id("name")).getAttribute("value"));
        check_emp.setSurname(driver.findElement(By.id("surname")).getAttribute("value"));
        check_emp.setPhone(driver.findElement(By.id("phone")).getAttribute("value"));
        check_emp.setE_mail(driver.findElement(By.id("e_mail")).getAttribute("value"));
        check_emp.setEducation(driver.findElement(By.id("education")).getAttribute("value"));
        check_emp.setPosition(driver.findElement(By.id("position")).getAttribute("value"));
        check_emp.setHome_address(driver.findElement(By.id("home_address")).getAttribute("value"));
        //check_emp.setWork_experience(work_exp.selectByVisibleText(new_emp.getWork_experience().toString()));

        driver.findElement(By.id("save_emp_button")).click();
        //Assert.assertEquals(driver.getTitle(), "Main Employee");
        Check_emps(new_emp, check_emp);

        //изменение информации о работнике
        driver.findElement(By.xpath(id_new)).click();
        //Assert.assertEquals(driver.getTitle(), "Update Employee");
        new_emp.setName("Alex");
        driver.findElement(By.id("name")).sendKeys(new_emp.getName());
        driver.findElement(By.id("save_emp_button")).click();
        //Assert.assertEquals(driver.getTitle(), "Main Employee");

        driver.findElement(By.xpath(id_new)).click();
        //Assert.assertEquals(driver.getTitle(), "Update Employee");
        check_emp.setName(driver.findElement(By.id("name")).getAttribute("value"));
        driver.findElement(By.id("save_emp_button")).click();
        //Assert.assertEquals(driver.getTitle(), "Main Employee");

        //Check_emps(new_emp, check_emp);

        //список услуг, которые предоставляет данный сотрудник
        String id = "//a[@href='/emp/" + "2" + "']" ;
        driver.findElement(By.xpath(id)).click();
        //Assert.assertEquals(driver.getTitle(), "Update Employee");
        driver.findElement(By.id("serv_button")).click();
        //Assert.assertEquals(driver.getTitle(), "Serv for emp");
        driver.findElement(By.id("all_emps_button")).click();
        //Assert.assertEquals(driver.getTitle(), "Main Employee");

        //удаление нового сотрудника
        driver.findElement(By.xpath(id_new)).click();
        //Assert.assertEquals(driver.getTitle(), "Update Employee");
        driver.findElement(By.id("delete_button")).click();
        //Assert.assertEquals(driver.getTitle(), "Main client");
    }

    @Test()
    public void Contract_Create_Test(){
        Contract contract = new Contract(15, 9, 10, java.sql.Date.valueOf("2011-01-01"), java.sql.Date.valueOf("2012-01-01"));

        driver.get(appURL);
        WebElement button = wait.until(visibilityOfElementLocated(By.id("new_contract_button")));
        Assert.assertEquals(driver.getTitle(), "Hello web app");

        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("save_contract_button")));
        Assert.assertEquals(driver.getTitle(), "Reg page");

        Select emp = new Select(driver.findElement(By.name("emp")));
        emp.selectByValue("3");

        Select client = new Select(driver.findElement(By.name("client")));
        client.selectByValue("172");

        Select serv = new Select(driver.findElement(By.name("serv")));
        serv.selectByValue("3");

        driver.findElement(By.name("date_of_begin")).sendKeys("2013-08-10");

        driver.findElement(By.name("date_of_end")).sendKeys("2020-09-01");
        button.click();
        wait.until(stalenessOf(button));
        Assert.assertEquals(driver.getTitle(), "Save page");

    }

    @Test()
    public void Error_CreationContract_Test(){
        driver.get(appURL);
        WebElement button = wait.until(visibilityOfElementLocated(By.id("new_contract_button")));
        Assert.assertEquals(driver.getTitle(), "Hello web app");
        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("save_contract_button")));
        Assert.assertEquals(driver.getTitle(), "Reg page");
        button.click();
        wait.until(stalenessOf(button));
        Assert.assertEquals(driver.getTitle(), "Error page");
    }

    @Test()
    public void Error_SelectEmp_Test() {
        driver.get(appURL);
        WebElement button = wait.until(visibilityOfElementLocated(By.id("all_emps_button")));
        Assert.assertEquals(driver.getTitle(), "Hello web app");
        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("select_button")));
        Assert.assertEquals(driver.getTitle(), "Main emp");
        button.click();
        wait.until(stalenessOf(button));
        Assert.assertEquals(driver.getTitle(), "Error page");
    }

    @Test()
    public void Error_SelectClient_Test() {
        driver.get(appURL);
        WebElement button = wait.until(visibilityOfElementLocated(By.id("all_clients_button")));
        Assert.assertEquals(driver.getTitle(), "Hello web app");
        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("select_button")));
        Assert.assertEquals(driver.getTitle(), "Main client");
        button.click();
        wait.until(stalenessOf(button));
        Assert.assertEquals(driver.getTitle(), "Error page");
    }
    @Test()
    public void Error_CreateClient_Test() {
        driver.get(appURL);
        WebElement button = wait.until(visibilityOfElementLocated(By.id("all_clients_button")));
        Assert.assertEquals(driver.getTitle(), "Hello web app");

        //переход на страницу клиентов
        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("new_client_button")));
        Assert.assertEquals(driver.getTitle(), "Main client");

        //переход на страницу создания нового клинета
        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("create_client_button")));
        Assert.assertEquals(driver.getTitle(), "New client");
        button.click();
        wait.until(stalenessOf(button));
        Assert.assertEquals(driver.getTitle(), "Error page");
    }

    @Test()
    public void Error_CreateEmp_Test() {
        driver.get(appURL);
        WebElement button = wait.until(visibilityOfElementLocated(By.id("all_emps_button")));
        Assert.assertEquals(driver.getTitle(), "Hello web app");

        //переход на страницу сотрудников
        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("new_emp_button")));
        Assert.assertEquals(driver.getTitle(), "Main emp");

        //переход на страницу создания нового сотрудника
        button.click();
        wait.until(stalenessOf(button));
        button = wait.until(visibilityOfElementLocated(By.id("create_emp_button")));
        Assert.assertEquals(driver.getTitle(), "New emp");
        button.click();
        wait.until(stalenessOf(button));
        Assert.assertEquals(driver.getTitle(), "Error page");
    }


   /* @Test()
    public void Select_ClientEmp_Test(){
        driver.get(appURL);
        Assert.assertEquals(driver.getTitle(), "Hello web app");
    }*/



    @AfterClass
    public void clear() {
        driver.quit();
    }

}
