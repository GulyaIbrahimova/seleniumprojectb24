package com.cybertek.tests.day14_webtables_properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.*;

public class LibraryLinkVerification {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://library2.cybertekschool.com/login.html");
    }
    @AfterTest
    public void tearDown(){
        //driver.quit();
    }
    @Test
    public void linkVerification(){
        driver.findElement(By.id("inputEmail")).sendKeys("student11@library");
        driver.findElement(By.id("inputPassword")).sendKeys("tScBPCUr");
        driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();
    }

}
/**
 1. Open browser
 2. Go to website: http://library2.cybertekschool.com/login.html
 3. Enter username: “”
 4. Enter password: “”
 5. Click to Login button
 6. Print out count of all the links on landing page
 7. Print out each link text on this page
 */