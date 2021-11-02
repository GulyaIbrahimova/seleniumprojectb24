package com.cybertek.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {
        //1.setup browser driver
        WebDriverManager.chromedriver().setup();

        //2.Open browser
        WebDriver driver = new ChromeDriver();

        //navigate to tesla homepage

        driver.get("https://www.tesla.com");

        //navigate back. similar to clicking back button on the browser

        driver.navigate().back();//similar to clicking back on the browser

        //pause the code. code will sleep/wait

        Thread.sleep(2000);

        driver.navigate().forward();//similar to clicking forward on the browser

        Thread.sleep(2000);

        driver.navigate().refresh();//refresh the page.

        Thread.sleep(2000);

        driver.navigate().to("https://www.bestbuy.com");

        //print title of the page
        System.out.println("current title: " + driver.getTitle());


        driver.quit();//close the browser







    }
}
