package web_test;

import entities.Client;
import entities.Contract;
import entities.Employee;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class web_test {

    protected final String appURL = "http://localhost:8080/greeting";
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        final String chromeDriverPath = "/Users/tanya/Downloads/chromedriver-2";  // "/usr/bin/google-chrome";

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1000, 1000));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test()
    public void Client_CreateDeleteUpdate_Test(){
        Client client = new Client("Tanya", "Ozerova", "8999999999", "tanyaozerova1318@gmail.com");

        driver.get(appURL);
        Assert.assertEquals(driver.getTitle(), "Hello web app");
    }

    @Test()
    public void Emp_CreateDeleteUpdate_Test(){
        Employee emp = new Employee("Igor", "Veremchuk", "8499999999", "igormemmory@gmail.com", "CMC MSU", "st. Angarskaya, 20, 2",  "associate", 2);

        driver.get(appURL);
        Assert.assertEquals(driver.getTitle(), "Hello web app");
    }

    @Test()
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
    public void Client_Serv_Test(){
        driver.get(appURL);
        Assert.assertEquals(driver.getTitle(), "Hello web app");
    }

    @Test()
    public void Emp_Serv_Test(){
        driver.get(appURL);
        Assert.assertEquals(driver.getTitle(), "Hello web app");
    }

}
