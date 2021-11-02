package com.cybertek.tests.day02_browser_level_operations;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class WebDriverFactoryTest {
    public static void main(String[] args) {

        WebDriver  driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com");

        driver.close();

        WebDriver driver2 = WebDriverFactory.getDriver("chrome");
        driver2.get("https://www.google.com");

        driver2.close();

        WebDriver driver3 = WebDriverFactory.getDriver("chrome");
        driver3.get("https://www.facebook.com");

        driver3.close();




    }


}
