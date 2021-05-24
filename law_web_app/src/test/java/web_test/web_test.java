package web_test;

import DAO_classes.DAO_client;
import entities.Client;
import entities.Contract;
import entities.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class web_test {

    protected final String appURL = "http://localhost:8080/greeting";
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        final String safariDriverPath = "/usr/bin/safaridriver";  // "/usr/bin/google-chrome";
        System.setProperty("webdriver.safari.driver", safariDriverPath);

        driver = new SafariDriver();
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1000, 1000));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        //Assert.assertEquals(driver.getTitle(), "Hello web app");

        //переход на страницу клиентов
        driver.findElement(By.id("all_clients_button")).click();
        //Assert.assertEquals(driver.getTitle(), "Main client");}

        //переход на страницу создания нового клинета
        driver.findElement(By.id("new_client_button")).click();
        //Assert.assertEquals(driver.getTitle(), "New client");

        //добавление нового клиента
        driver.findElement(By.id("name")).sendKeys(new_client.getName());
        driver.findElement(By.id("surname")).sendKeys(new_client.getSurname());
        driver.findElement(By.id("phone")).sendKeys(new_client.getPhone());
        driver.findElement(By.id("e_mail")).sendKeys(new_client.getE_mail());

        driver.findElement(By.id("create_client_button")).click();
        //Assert.assertEquals(driver.getTitle(), "Main client");

        DAO_client dao_client = new DAO_client();
        List<Client> l = dao_client.ListClient ();
        int max_id = 0;
        for (Client cl : l)
            if (cl.getId()>max_id)
                max_id = cl.getId();

        //проверка, что клиент добавлен корректно
        String id_new = "//a[@href='/client/" + max_id + "']" ;
        String id = "//a[@href='/client/" + "171" + "']" ;

        driver.findElement(By.xpath(id_new)).click();
        //Assert.assertEquals(driver.getTitle(), "Update client");

        Client check_client = new Client();
        check_client.setName(driver.findElement(By.id("name")).getAttribute("value"));
        check_client.setSurname(driver.findElement(By.id("surname")).getAttribute("value"));
        check_client.setPhone(driver.findElement(By.id("phone")).getAttribute("value"));
        check_client.setE_mail(driver.findElement(By.id("e_mail")).getAttribute("value"));

        driver.findElement(By.id("save_client_button")).click();
        //Assert.assertEquals(driver.getTitle(), "Main client");
        Check_clients(new_client, check_client);

        //изменеиние информации о клиенте
        new_client.setName("Anna");
        driver.findElement(By.xpath(id_new)).click();
        //Assert.assertEquals(driver.getTitle(), "Update client");

        driver.findElement(By.id("name")).sendKeys(new_client.getName());
        driver.findElement(By.id("save_client_button")).click();
        //Assert.assertEquals(driver.getTitle(), "Main client");

        driver.findElement(By.xpath(id_new)).click();
        //Assert.assertEquals(driver.getTitle(), "Update client");

        check_client.setName(driver.findElement(By.id("name")).getAttribute("value"));
        driver.findElement(By.id("save_client_button")).click();
        //Assert.assertEquals(driver.getTitle(), "Main client");
        Check_clients(new_client, check_client);

        //услуги существующего клиента
        driver.findElement(By.xpath(id)).click();
        driver.findElement(By.id("serv_button")).click();
        //Assert.assertEquals(driver.getTitle(), "Serv for client");

        driver.findElement(By.id("all_clients_button")).click();
        //Assert.assertEquals(driver.getTitle(), "Main client");

        //удаление нового клиента
        driver.findElement(By.xpath(id_new)).click();
        driver.findElement(By.id("delete_button")).click();
        //Assert.assertEquals(driver.getTitle(), "Main client");

    }

   /* @Test()
    public void Emp_CreateDeleteUpdate_Test(){
        Employee new_emp = new Employee("Igor", "Veremchuk", "8499999999", "igormemmory@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2",  "associate", 2);

        driver.get(appURL);
        Assert.assertEquals(driver.getTitle(), "Hello web app");

        driver.findElement(By.id("all_emps_button")).click();
        Assert.assertEquals(driver.getTitle(), "Main emp");

        driver.findElement(By.id("new_emp_button")).click();
        Assert.assertEquals(driver.getTitle(), "New emp");

        driver.findElement(By.id("name")).sendKeys(new_emp.getName());
        driver.findElement(By.id("surname")).sendKeys(new_emp.getSurname());
        driver.findElement(By.id("phone")).sendKeys(new_emp.getPhone());
        driver.findElement(By.id("e_mail")).sendKeys(new_emp.getE_mail());
        driver.findElement(By.id("education")).sendKeys(new_emp.getEducation());
        driver.findElement(By.id("home_address")).sendKeys(new_emp.getHome_address());
        driver.findElement(By.id("position")).sendKeys(new_emp.getPosition());
        //driver.findElement(By.id("work_experience")).sendKeys(new_emp.getWork_experience());
        driver.findElement(By.id("create_client_button")).click();
        driver.findElement(By.id("create_emp_button")).click();
        Assert.assertEquals(driver.getTitle(), "Main emp");
    }

   /* @Test()
    public void Contract_Create_Test(){
        Contract contract = new Contract(15, 9, 10, java.sql.Date.valueOf("2011-01-01"), java.sql.Date.valueOf("2012-01-01"));

        driver.get(appURL);
        Assert.assertEquals(driver.getTitle(), "Hello web app");
    }

    @Test()
    public void Select_Client_Test(){
        driver.get(appURL);
        Assert.assertEquals(driver.getTitle(), "Hello web app");
    }

    @Test()
    public void Select_Emp_Test(){
        driver.get(appURL);
        Assert.assertEquals(driver.getTitle(), "Hello web app");
    }

    @Test()
    public void Error_Test(){
        driver.get(appURL);
        Assert.assertEquals(driver.getTitle(), "Hello web app");
    }

    @Test()
    public void Emp_Serv_Test(){
        driver.get(appURL);
        Assert.assertEquals(driver.getTitle(), "Hello web app");
    }

    @Test()
    public void Emp_Serv_Test(){
        driver.get(appURL);
        Assert.assertEquals(driver.getTitle(), "Hello web app");

    }*/

    /*@AfterClass
    public void clear() {
        driver.quit();
    }*/

}
