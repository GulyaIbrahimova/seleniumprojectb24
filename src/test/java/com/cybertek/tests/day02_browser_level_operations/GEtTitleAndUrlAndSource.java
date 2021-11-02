package com.cybertek.tests.day02_browser_level_operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GEtTitleAndUrlAndSource {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();//setup browser, before Boni garcia
        String url ="https://www.etsy.com";
        WebDriver driver = new ChromeDriver();// created driver object
        //this code opens the browser, but it is still empty

        driver.get(url);// we don't have to type url, cause already created variable

        //read the title of the page and print out
        System.out.println("Title: " + driver.getTitle());

        //this time do it with storing the title into String variable
        String etsyTitle = driver.getTitle();
        System.out.println("etsyTitle " + etsyTitle);

        //read the url of the current page
        System.out.println("Current url: " + driver.getCurrentUrl());
        //store the url into a String variable
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current Url " + driver.getCurrentUrl());// method is behavior of the Class

        //read page source and print it
        System.out.println("HTML page source " + driver.getPageSource());

        //store the source code into a variable then print the char count
       String html = driver.getPageSource();
        System.out.println("Count of character in html " +html.length());

        //close the browser driver.close();, driver.quit();
        driver.quit();





    }

}
