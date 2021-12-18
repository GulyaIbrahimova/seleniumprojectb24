package com.cybertek.tests.day09_testng_dropdowns;

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

public class DropDownTask {
    String url = "http://practice.cybertekschool.com/dropdown";
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test(priority = 1)
    public void simpleDropDownN1(){
        Select simpleDropDown = new Select(driver.findElement(By.id("dropdown")));
        WebElement actualValueSimpleDropDown = driver.findElement(By.xpath("//option[.='Please select an option']"));
        Assert.assertEquals(actualValueSimpleDropDown.getText(),"Please select an option");

        WebElement actualValueStateSelection = driver.findElement(By.xpath("//option[.='Select a State']"));
        Assert.assertEquals(actualValueStateSelection.getText(),"Select a State");
    }
    @Test(priority = 2)
    public void stateSelectionN2(){
        Select stateSelection =new Select( driver.findElement(By.id("state")));
        driver.findElement(By.xpath("//option[.='Select a State']")).click();
        stateSelection.selectByValue("IL");
        stateSelection.selectByValue("VA");
        stateSelection.selectByValue("CA");
        WebElement lastSelected = driver.findElement(By.xpath("//option[.='California']"));
        Assert.assertEquals(lastSelected.getText(),"California");
    }
    @Test(priority = 3)
    public void selectDateN3(){
        Select selectYear = new Select(driver.findElement(By.id("year")));
        selectYear.selectByVisibleText("1922");
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByValue("11");
        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByValue("1");

    }
    @Test(priority = 4)
    public void multipleSelectDropDown(){
        Select multipleDropDown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        multipleDropDown.selectByValue("java");
        multipleDropDown.selectByValue("js");
        multipleDropDown.selectByValue("c#");
        multipleDropDown.selectByValue("python");
        multipleDropDown.selectByValue("ruby");
        multipleDropDown.selectByValue("c");
    }
    @Test(priority = 5)
    public void nonSelectDropDown(){
        driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']")).click();
        driver.findElement(By.xpath("//a[.='Facebook']")).click();
        Assert.assertEquals(driver.getTitle(),"Facebook - Log In or Sign Up");

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
/**
 /**
 TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
 1. Open Chrome browser
 2. Go to http://practice.cybertekschool.com/dropdown
 3. Verify “Simple dropdown” default selected value is correct
 Expected: “Please select an option”
 4. Verify “State selection” default selected value is correct
 Expected: “Select a State”


 TC #2: Selecting state from State dropdown and verifying result
 1. Open Chrome browser
 2. Go to http://practice.cybertekschool.com/dropdown
 3. Select Illinois
 4. Select Virginia
 5. Select California
 6. Verify final selected option is California.
 Use all Select options. (visible text, value, index)

 TC #3: Selecting date on dropdown and verifying
 1. Open Chrome browser
 2. Go to http://practice.cybertekschool.com/dropdown
 3. Select “December 1st, 1922” and verify it is selected.
 Select year using : visible text
 Select month using : value attribute
 Select day using : index number


 TC #4: Selecting value from multiple select dropdown
 1. Open Chrome browser
 2. Go to http://practice.cybertekschool.com/dropdown
 3. Select all the options from multiple select dropdown.
 4. Print out all selected values.
 5. Deselect all values.


 TC #5: Selecting value from non-select dropdown
 1. Open Chrome browser
 2. Go to http://practice.cybertekschool.com/dropdown
 3. Click to non-select dropdown
 4. Select Facebook from dropdown
 5. Verify title is “Facebook - Log In or Sign Up
 */