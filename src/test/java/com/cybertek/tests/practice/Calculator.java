package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calculator {

    public static void main(String[] args) {
        //launch browser, maximize
        WebDriverManager.chromedriver().setup();

        //launch Selenium webdriver
        WebDriver driver = new ChromeDriver();

        //maximize browser
        driver.manage().window().maximize();

        driver.get("https://www.calculator.net");

        //click on percentage calculator
        driver.findElement(By.linkText("Percentage Calculator")).click();

        //verify currant title is
        String exTitle = "Percentage Calculator";
        String acTitle = driver.getTitle();
        System.out.println("acTitle = " + acTitle);

        if (acTitle.equals(exTitle)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }//enter 20%







        //driver.close();

    }
}
