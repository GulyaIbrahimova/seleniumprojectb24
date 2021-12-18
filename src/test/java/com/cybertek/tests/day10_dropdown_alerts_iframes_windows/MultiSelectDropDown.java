package com.cybertek.tests.day10_dropdown_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class MultiSelectDropDown {
    String url = "http://practice.cybertekschool.com/dropdown";
    WebDriver driver;//can use in every method

    @BeforeMethod
    public void setUp(){
        driver= getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void multiSelectDropDown(){
        Select languages = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        languages.selectByVisibleText("Java");
        languages.selectByVisibleText("JavaScript");
        languages.selectByVisibleText("Python");

        //to select all of them use loop
        /**
         List<WebElement> allLanguages = languages.getOptions();
         for (WebElement eachLanguage : allLanguages) {
         languages.selectByVisibleText(eachLanguage.getText());
         }

         or short way down below:
          */


        for (WebElement eachLanguage : languages.getOptions()) {//getOptions(); method returns list of webElements
            eachLanguage.click();
            languages.selectByVisibleText(eachLanguage.getText());

            //The isSelected() method checks that if an element is selected on the web page or not. It can be executed only on a  radio button, checkbox, and so on.
            assertTrue(eachLanguage.isSelected(),"");
        }

        languages.deselectAll();


    }

}
