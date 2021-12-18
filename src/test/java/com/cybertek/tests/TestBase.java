package com.cybertek.tests;

import com.cybertek.utils.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public abstract class TestBase {
    protected WebDriver driver;//not in the same pcg, any class that inherits this will be able to use it. protected is accessible by sub classes in different packages
    protected  Faker faker = new Faker();
    protected Actions actions;
  //  protected WebDriverWait wait;//explicit wait object

    //Could put it here too: protected JavascriptExecutor js = (JavascriptExecutor) driver; but no need

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        actions = new Actions(driver);
    //    wait = new WebDriverWait(driver, 20);
    }
    @AfterMethod
    public void tearDown(){
        //Driver.closeDriver(); //it wll close only current one

}

}
