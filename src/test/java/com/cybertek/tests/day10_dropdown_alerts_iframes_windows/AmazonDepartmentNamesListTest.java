package com.cybertek.tests.day10_dropdown_alerts_iframes_windows;

import static com.cybertek.utils.WebDriverFactory.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

//import all static methods/variables of Assert class
import static org.testng.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDepartmentNamesListTest {
    String url = "https://amazon.com";
    WebDriver driver;//can use in every method

    @BeforeMethod
    public void setUp(){
        driver= getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void amazonDepartmentSearch() throws InterruptedException {
        /**
         assert Amazon home page is displayed
         assert All option selected by default
         get All available options and print out
         */

        //assert fail rest of the code doesn't execute
        //checking the title

        assertEquals(driver.getTitle(),"Amazon.com. Spend less. Smile more.");

        Select departments = new Select(driver.findElement(By.id("searchDropdownBox")));
        String selectedOption = departments.getFirstSelectedOption().getText();
        assertEquals(selectedOption,"All Departments");

        //similar to findElements equals to List<WebElements>

        //go to Select dropdown and read all list elements
        List<WebElement> allDepartments=departments.getOptions();
        System.out.println("Number of departments: " + allDepartments.size());
        //lambda
        assertTrue(allDepartments.size()>10,"Department names are failing");//it is good to add "" if it is an error it will show an error message

        //loop and print all avialable options

        for (WebElement department : allDepartments) {

            System.out.println(department.getText());
        }
        System.out.println("USING FOR EACH METHOD USING LAMBDA EXPRESSION");
         allDepartments.forEach(eachDept-> System.out.println(eachDept.getText()));

        //select each item by order and wait 400 ms in between
        for (WebElement dept: allDepartments){
            departments.selectByVisibleText(dept.getText());

        }

        }
        @Test(enabled=false)//skip the test if it is not failing
    public void testDemo(){
            System.out.println("Test Demo is Running ");

        }
        @AfterMethod
    public void tearDown(){
        driver.quit();
        }

    }











