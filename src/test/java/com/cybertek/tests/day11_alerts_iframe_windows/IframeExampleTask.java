package com.cybertek.tests.day11_alerts_iframe_windows;

import org.openqa.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class IframeExampleTask {

    WebDriver driver;
    String url ="http://practice.cybertekschool.com/iframe";

    @BeforeMethod
    public void setUp(){
        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void iframeTest(){
        //Switch to the frame by id "mce_0_ifr"
        driver.switchTo().frame("mce_0_ifr");

        WebElement commentField = driver.findElement(By.id("tinymce"));
        System.out.println("commentField: " + commentField.getText());
        commentField.clear();
        commentField.sendKeys("hello hello");

        //go out from Iframe back to main content

        driver.switchTo().defaultContent();

    }
    @Test
    public void multipleFrameTest(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        //find count of frames on this page

        driver.switchTo().frame("frame-bottom");
        WebElement bodyElem = driver.findElement(By.tagName("body"));
        System.out.println("Text of bottom frame = " + bodyElem.getText());
        driver.switchTo().defaultContent();

        //switch to 1st frame(index 0)
        driver.switchTo().frame(0).switchTo().frame(0);//parent has 3 child, we are going with 1st one
        bodyElem = driver.findElement(By.tagName("body"));
        System.out.println("Frame 0 body elem text = " + bodyElem.getText());

        //go back to parent frame, then defaultContent
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

        driver.switchTo().frame(0).
                switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_right']")));
        bodyElem = driver.findElement(By.tagName("body"));
        System.out.println("Frame right body text element = " + bodyElem.getText());










    }


}
//        List<WebElement>frames = driver.findElements(By.tagName("frame"));
//        System.out.println("counts of frames= " + frames.size());