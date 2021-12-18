package com.cybertek.tests.day16_download_uploaded_js_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class LibrarySoftwareLinkVerif extends TestBase {
    /**
     Task #1: Library software link verification
     1. Open browser
     2. Go to website: http://library2.cybertekschool.com/login.html
     3. Enter username: “”
     4. Enter password: “”
     5. Click to Login button
     6. Print out count of all the links on landing page
     7. Print out each link text on this page
     */

    @Test
    public void linkVerification(){
        driver.get(ConfigurationReader.getProperty("library2.url"));
        driver.findElement(By.id("inputEmail")).sendKeys("student30@library");
        driver.findElement(By.id("inputPassword")).sendKeys("Sdet2022*");
        driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            System.out.println( "Links -" + link.getAttribute("href"));

        }

       /**
        * List<WebElement> linksForBorrowBook = driver.findElements(By.xpath("//tbody/tr/td/a"));
        * System.out.println(linksForBorrowBook.size());
        *         for (WebElement link : linksForBorrowBook) {
        *             System.out.println("Link name = " + link.getText());
        *
        *         }List <WebElement> linksForNumbers =driver.findElements(By.xpath("//div/ul/li/a"));
        System.out.println(linksForNumbers.size());
        for (WebElement linksForNumber : linksForNumbers) {
            System.out.println("Number links " + linksForNumber.getText());

        }

        */

    }

}
