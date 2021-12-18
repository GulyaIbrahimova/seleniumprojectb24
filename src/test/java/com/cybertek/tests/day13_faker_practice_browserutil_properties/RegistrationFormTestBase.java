package com.cybertek.tests.day13_faker_practice_browserutil_properties;

import static com.cybertek.utils.WebDriverFactory.getDriver;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import static com.cybertek.utils.WebDriverFactory.getDriver;

import java.util.concurrent.TimeUnit;

/**
 Parent class for registrtationFormTest
 created by: Murodil -  no need since

whatever in the parent runs 1st

 */
public class RegistrationFormTestBase {
    WebDriver driver;
    String url = "http://practice.cybertekschool.com/registration_form";

    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }

}
