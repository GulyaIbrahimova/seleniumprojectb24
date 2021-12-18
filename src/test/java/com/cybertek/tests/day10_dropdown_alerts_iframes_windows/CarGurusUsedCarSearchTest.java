package com.cybertek.tests.day10_dropdown_alerts_iframes_windows;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CarGurusUsedCarSearchTest {


    String url = "https://cargurus.com";
    WebDriver driver;//can use in every method

    @BeforeClass
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void searchForMinivanTest() {

        //verify on correct page
        String expTitle = "Buy & Sell Cars: Reviews, Prices, and Financing - CarGurus";
        Assert.assertEquals(driver.getTitle(), expTitle);
    }
        @Test
     public void selectMinivan(){
        //select make
        Select make = new Select(driver.findElement(By.id("carPickerUsed_makerSelect")));
        make.selectByVisibleText("Toyota");

        //make.selectByValue("m7"); By html value: <option value="m7">Toyota</option>
        // make.selectByIndex(34);

         //select model
         Select model = new Select(driver.findElement(By.id("carPickerUsed_modelSelect")));
         model.selectByValue("d308");//Sienna

         //type zipcode -> 92071
         driver.findElement(By.name("zip")).sendKeys("92071");
         //print currently selected options make and model:

         System.out.println("Selected make: " + make.getFirstSelectedOption().getText());
         System.out.println("Selected model: " + model.getFirstSelectedOption().getText());

         //driver.findElement(By.xpath("//input[@type='submit']")).click();//can be general
         driver.findElement(By.id("dealFinderForm_0")).click();

         //how to find how many listing results we got
         WebElement resultCount = driver.findElement(By.xpath("//span[@class='oKvYB4']/strong[2]"));
         System.out.println("Number of results: "+ resultCount.getText());

         //assert that count is more than 0
            int count = Integer.parseInt(resultCount.getText());
            Assert.assertTrue(count > 0);

        }

    }
