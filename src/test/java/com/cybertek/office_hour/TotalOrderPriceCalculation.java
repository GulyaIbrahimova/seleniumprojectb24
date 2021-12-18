package com.cybertek.office_hour;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**Test Case 1:
 Total Order Price Calculation 1
 - Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
 - Login with username: Tester, password: test
 - Click  Order button
 - Verify under Product Information, selected option is “MyMoney”
 -Then select FamilyAlbum, make quantity 2, and click Calculate,
 - Then verify Total is equal to Quantity*PricePerUnit */



public class TotalOrderPriceCalculation {
    WebDriver driver;
    String url = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
    WebElement userName;
    WebElement passWord;

    @BeforeClass
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void TC1(){
        userName=driver.findElement(By.id("ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        passWord=driver.findElement(By.id("ctl00_MainContent_password"));
        passWord.sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        WebElement orderBtn=driver.findElement(By.linkText("Order"));
        orderBtn.click();
        Select selectProduct = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        String selectedOption = selectProduct.getFirstSelectedOption().getText();
        String expected ="MyMoney";
        assertEquals(selectProduct.getFirstSelectedOption().getText(),expected);
        selectProduct.selectByValue("FamilyAlbum");

        WebElement quantityField = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
        quantityField.sendKeys("2");
        WebElement calculate = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculate.click();

        int quantity = Integer.parseInt(quantityField.getAttribute("value"));
        System.out.println("quantity = " + quantity);

        WebElement unitPriceField = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtUnitPrice"));
        int pricePerUnit = Integer.parseInt(unitPriceField.getAttribute("value"));
        System.out.println("Price per unit = " + pricePerUnit);

        WebElement totalPrice = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtTotal']"));
        int total = Integer.parseInt(totalPrice.getAttribute("value"));

        assertEquals(total, quantity * pricePerUnit);
        System.out.println("Total = " + total);


    }

}
