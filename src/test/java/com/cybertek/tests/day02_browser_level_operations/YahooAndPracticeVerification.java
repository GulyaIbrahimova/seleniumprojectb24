package com.cybertek.tests.day02_browser_level_operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
TC #1: Yahoo Title Verification
1. Open Chrome browser
2. Go to https://www.yahoo.com/
3. Verify title:
Expected: Yahoo
 */

public class YahooAndPracticeVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url ="https://www.yahoo.com";
        driver.get(url);
        String expectedTitle= "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";
        System.out.println(expectedTitle);

        String actualTitle= driver.getTitle();
        System.out.println(actualTitle);

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Pass: title verification successful");

        }else{
            System.out.println("Fail: title verification failed");
        }
    driver.quit();


    }



}
