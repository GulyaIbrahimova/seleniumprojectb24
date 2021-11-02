package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_ClickGmailVerifyTitle {
    /*

    TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google
     */
    public static void main(String[] args) {


    WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();//making window full screen

        String url = "https://www.google.com";//creating url var.
        driver.get(url);

        //find Gmail and click on it

        driver.findElement(By.linkText("Gmail")).click();//First command webElement
        //findElement=> method that finds elements
        //linkText("Gmail")) => locator and value for how to find the element on the page
        //.click() => action to do after finding it

        //verify title contains/start with Gmail
         String expectedTitle = "Gmail";
         String actualTitle = driver.getTitle();

         if (actualTitle.contains(expectedTitle)){
             System.out.println("PASS: gmail title verification successful! ");
         }else {
             System.out.println("FAIL: gmail title verification failed! ");
         }

         //driver.findElement(By.partialLinkText("Yahoo")).click();//output: For documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html

         //go back
         driver.navigate().back();

         String googleExpectedTitle = "Google";
         String googleActualTitle = driver.getTitle();
         if (googleActualTitle.contains(googleExpectedTitle)){
             System.out.println("PASS: Google title verification successful! ");
         }else {
             System.out.println("FAIL: Google title verification failed! ");
         }

         driver.quit();


    }
}
