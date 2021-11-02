package com.cybertek.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestClass {

    public static void main(String[] args) {

        //1- set up the web driver

        WebDriverManager.chromedriver().setup();//chromedriver() -> static method

        //2- create the instance of the chrome driver.

        WebDriver driver = new ChromeDriver();//Create the object of ChromeDriver class. Once we create the object of this class it opens the chrome website.  driver -> is variable name, can be anything
        /*
        just like with Arraylist:
        List <Integer> nums= new Arraylist<>();
        or
        Arraylist <Integer> nums= new Arraylist<>();

         */

        //3- test if driver is working

        driver.get("https://www.google.com");





    }
}
