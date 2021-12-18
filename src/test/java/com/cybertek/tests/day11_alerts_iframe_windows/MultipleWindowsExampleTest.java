package com.cybertek.tests.day11_alerts_iframe_windows;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class MultipleWindowsExampleTest {

    WebDriver driver;
    String url ="http://practice.cybertekschool.com/windows";
    String demoQAUrl = "https://demoqa.com/browser-windows";

    @BeforeMethod
    public void setUp(){
        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }
    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
    @Test
    public void windowsTest(){
        driver.get(url);
        //get window handle of current window
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("windowHandle = " + mainWindowHandle);

        //click on new window
        WebElement newWindowLink = driver.findElement(By.linkText("Click Here"));
        newWindowLink.click();

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Count of windows= " + windowHandles.size());

        //print all window handles
        System.out.println("windowHandles = " + windowHandles);
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            System.out.println("CURRENT window title: " + driver.getTitle());

        }
        WebElement h3Elem = driver.findElement(By.xpath("//h3"));
        System.out.println("h3header text on new page = " + h3Elem.getText());

        //go back to parent window/main window
        driver.switchTo().window(mainWindowHandle);
        System.out.println("Title after switching back to main window: " + driver.getTitle());

    }
    @Test
    public void demoQAMultipleWindows(){
        driver.get(demoQAUrl);
        WebElement newTab = driver.findElement(By.id("tabButton"));
        WebElement newWindow = driver.findElement(By.id("windowButton"));
        WebElement newWindowWithMSg = driver.findElement(By.id("messageWindowButton"));
        newTab.click();
        newWindow.click();
        newWindowWithMSg.click();

        System.out.println("Title of the main page " + driver.getTitle());

        //store parent window handle id in a variable:

        String parentWindowHandle = driver.getWindowHandle();

        //Store all window handle IDs in to a Set
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("Total window count: " + allWindowHandles.size());

        for (String eachWinHandle:allWindowHandles) {
            System.out.println("Switching to new window"+eachWinHandle);
            driver.switchTo().window(eachWinHandle);
           // System.out.println("Title: "+driver.getTitle());

        }


    }
}
