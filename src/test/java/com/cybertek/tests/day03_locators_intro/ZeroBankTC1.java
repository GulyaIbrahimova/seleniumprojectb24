package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankTC1 {
    /*
    TC #1: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”

     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "http://zero.webappsecurity.com/login.html";
        driver.get(url);


        String expectedHeader = "Log in to ZeroBank";//<
        String actualHeader = driver.findElement(By.tagName("h3")).getText();
        System.out.println("header = "+ actualHeader);

        //verify header text
      //System.out.println(actualHeader.equals(expectedHeader)? "PASS": "FAIL");

        if (expectedHeader.equals(actualHeader)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        //We can use multiple locator. link : https://stackoverflow.com/questions/45278946/how-to-use-multiple-locators-to-find-an-element-in-selenium-webdriver
    }

}
