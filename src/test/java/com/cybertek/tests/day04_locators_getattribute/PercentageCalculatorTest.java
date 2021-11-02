package com.cybertek.tests.day04_locators_getattribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PercentageCalculatorTest {
    public static void main(String[] args) throws InterruptedException {

        /*

        Main method:
    - launch browser, maximize
    - navigate to https://www.calculator.net/
    - Click on Percentage Calculator
    - Verify current title is "Percentage Calculator"
    - Enter 20% of 120000 and click enter (using Keys.ENTER)
    - Print the result "Result: 24000"
    - close browser
         */


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //- navigate to https://www.calculator.net/
        driver.get("https://www.calculator.net/");

        //- Click on Percentage Calculator
        driver.findElement(By.linkText("Percentage Calculator")).click();//By.linkText is locator, By is a class

        //create a variable
        String actualTitle= driver.getTitle();
        String expectedTitle  = "Percentage Calculator";

        //go yo website, inspect, go to head, find title in there

        //- Verify current title is "Percentage Calculator"

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Pass: Title verification successful");
        }else{
            System.out.println("Fail: Title verification failed ");
        }
        //print actual title
        System.out.println("actualTitle = " + actualTitle);

        //Enter 20% of 120000

        driver.findElement(By.id("cpar1")).sendKeys("20");

        //and click enter (using Keys.ENTER)
        driver.findElement(By.id("cpar2")).sendKeys("120000", Keys.ENTER);
        //2nd option
        //driver.findElement(By.id("cpar2")).sendKeys("120000" +  Keys.ENTER);

        //- Print the result "Result: 24000"

        String result = driver.findElement(By.className("h2result")).getText();
        System.out.println("result = " + result);

        //to check to the last portion

        if (result.endsWith("24000")){
            System.out.println("Pass: calculation is correct");
        }else {
            System.out.println("Fail: calculation is incorrect");
        }

        Thread.sleep(2000);

        driver.close();
        /*
        output:
        Pass: Title verification successful
        actualTitle = Percentage Calculator
        result = Result: 24000
        Pass: calculation is correct
         */


    }
}
