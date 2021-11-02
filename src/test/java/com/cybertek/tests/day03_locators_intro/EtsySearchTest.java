package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsySearchTest {
    /*
    Create a class EtsySearchTest
    Navigate to etsy homepage
    Search for "wooden spoon"
    Verify title starts with "wooden spoon"
    Click on "Holiday Shop" link
    Read the text of the Header using h1 tag
    Verify the header equals "Holiday Shop"
    Close the browser
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Navigate to etsy homepage
        String url = "https://www.etsy.com";
        driver.get(url);

        //Search for "wooden spoon"
        driver.findElement(By.name("search_query")).sendKeys("wooden spoon" + Keys.ENTER);

        //Verify title starts with "wooden spoon"
        String actTitle = driver.getTitle();
        String expTitle = "wooden spoon";
        System.out.println(expTitle.equals(actTitle)? "PASS: title match": "FAIL: Title mismatch");//Title mismatch= > actual title is "Wooden spoon"
        System.out.println("actTitle = " + actTitle);//actTitle = Wooden spoon | Etsy

        driver.navigate().back();

        //Click on "Holiday Shop" link
        driver.findElement(By.linkText("Holiday Shop")).click();

        //Read the text of the Header using h1 tag
        String actHeader = driver.findElement(By.tagName("h1")).getText();
        String expHeader = "Holiday Shop";
        System.out.println(expHeader.startsWith(actHeader)? "PASS: Header match" : "FAIL: Header mismatch");
        System.out.println("actHeader = " + actHeader);

        Thread.sleep(2000);

        driver.quit();


    }
}
