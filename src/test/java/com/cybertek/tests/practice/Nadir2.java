package com.cybertek.tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class Nadir2 {

    String url = "http://te.dev.secureci.com/Exercise2.html";
    WebDriver driver;//can use in every method

    @BeforeMethod
    public void setUp(){
        driver= getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void testC(){

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='slider round']"));

        for (WebElement element : elements) {
            element.click();
        }
    }
}
