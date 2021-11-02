package com.cybertek.tests.day03_locators_intro.facebook_tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2_FacebookIncorrectLogin {
    /*
    TC #2: Facebook incorrect login title verification
    1. Open Chrome browser
    2. Go to https://www.facebook.com
    3. Enter incorrect username
    4. Enter incorrect password
    5. Verify title changed to:
    Expected: “Log into Facebook”

     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //1. Open Chrome browser
        String url = "https://www.facebook.com";
        driver.get(url);

        String userName = "gulyaa";
        String passWord = "00123";
        driver.findElement(By.id("email")).sendKeys(userName);
        driver.findElement(By.id("pass")).sendKeys(passWord);

        driver.findElement(By.name("login")).click();

        //output: The password you’ve entered is incorrect. Forgot Password?
        Thread.sleep(2000);

        String expTitle = "Log into Facebook";
        String actTitle = driver.getTitle();
        System.out.println(actTitle.equals(expTitle)? "PASS: Title changed to \"Log into Facebook\"": "FAIL: Title mismatch");
        System.out.println("actTitle = " + actTitle);

    }
}
