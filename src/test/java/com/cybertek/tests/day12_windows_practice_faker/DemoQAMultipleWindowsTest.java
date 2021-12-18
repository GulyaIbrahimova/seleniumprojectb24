package com.cybertek.tests.day12_windows_practice_faker;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class DemoQAMultipleWindowsTest {
    WebDriver driver;
    String demoQAUrl = "https://demoqa.com/browser-windows";

    @BeforeMethod
    public void setUp(){
        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(demoQAUrl);
    }
    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }

    /**
     Click on New Window Button
     Switch to new Window
     Locate and print the message
     Close the window
     Go back to main window

     */
    @Test
    public void newWindowTest() throws InterruptedException {
        WebElement newWindowBtn = driver.findElement(By.cssSelector("#windowButton"));//whenever we put #
        newWindowBtn.click();
        Thread.sleep(2000);
        //        driver.close();//close currently active window, it will close the parent one
        //        driver.quit();//closes all opened windows in same session

        Set<String> windowHandles = driver.getWindowHandles();
        String parentWindowHandle = driver.getWindowHandle();//store current window handle

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                //how to know if it is 1st one
            }
        }
        WebElement header = driver.findElement((By.cssSelector("#sampleHeading")));
        System.out.println("header= " + header.getText());
        Thread.sleep(2000);
        driver.close();//closes current window

        //go back to parent window


        driver.switchTo().window(parentWindowHandle);
        System.out.println("title = " + driver.getTitle());

    }

}
