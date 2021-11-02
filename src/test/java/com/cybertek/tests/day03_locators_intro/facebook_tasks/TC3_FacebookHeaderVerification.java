package com.cybertek.tests.day03_locators_intro.facebook_tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_FacebookHeaderVerification {

    public static void main(String[] args) throws InterruptedException {
        /*
        TC #3: Facebook header verification
        1. Open Chrome browser
        2. Go to https://www.facebook.com
        3. Verify header text is as expected:
        Expected: “Connect with friends and the world around you on Facebook.”
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //1. Open Chrome browser
        String url = "https://www.facebook.com";
        driver.get(url);
        String expHeader = "Connect with friends and the world around you on Facebook.";
        String actHeader= driver.findElement(By.tagName("h2")).getText();

        if (expHeader.equals(actHeader)){
            System.out.println("PASS: Header match");
        }else{
            System.out.println("FAIL: Header mismatch");
        }
        System.out.println("actHeader = " + actHeader);
        Thread.sleep(2000);
        driver.quit();
    }
}
