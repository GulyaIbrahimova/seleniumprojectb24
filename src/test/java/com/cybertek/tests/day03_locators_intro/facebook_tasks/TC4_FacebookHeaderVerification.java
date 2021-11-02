package com.cybertek.tests.day03_locators_intro.facebook_tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4_FacebookHeaderVerification {
    public static void main(String[] args) throws InterruptedException {
        /*
        TC #4: Facebook header verification
        1. Open Chrome browser
        2. Go to https://www.facebook.com
        3. Verify “Create a page” link href value contains text:
        Expected: “registration_form”
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //1. Open Chrome browser
        String url = "https://www.facebook.com";

        //2. Go to https://www.facebook.com
        driver.get(url);

        //create a page link for href link
        WebElement createPage = driver.findElement(By.linkText("Create a Page"));

        // create a string var. to store href value
        String expHrefValue = "registration_form";
        String actHrefValue = createPage.getAttribute("href");

        //verify if link contains expected "registration form"
        System.out.println(actHrefValue.contains(expHrefValue)? "PASS: Contains href value": "FAIL: Verification fails");

        Thread.sleep(2000);

        driver.close();


    }
}
