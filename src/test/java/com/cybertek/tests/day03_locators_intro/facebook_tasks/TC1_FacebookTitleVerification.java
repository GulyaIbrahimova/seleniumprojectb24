package com.cybertek.tests.day03_locators_intro.facebook_tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1_FacebookTitleVerification {
    public static void main(String[] args) {
        /*
        TC #1: Facebook title verification
        1. Open Chrome browser
        2. Go to https://www.facebook.com
        3. Verify title:
        Expected: “Facebook - Log In or Sign Up”
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //1. Open Chrome browser
        String url = "https://www.facebook.com";
        driver.get(url);
        String expTitle = "Facebook - Log In or Sign Up";
        String actTitle = driver.getTitle();
        System.out.println(expTitle.equals(actTitle)? "PASS: Title match": "FAIL: Title mismatched");
        System.out.println("actTitle = " + actTitle);



    }
}
