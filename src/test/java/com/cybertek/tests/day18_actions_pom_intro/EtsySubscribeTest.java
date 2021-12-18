package com.cybertek.tests.day18_actions_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.security.Key;

import static org.testng.Assert.*;

/**
 Goto Etsy homepage
 Scroll down
 Generate random email and enter into subscribe box
 Click on Subscribe
 Verify "Great! We've sent you an email to confirm your subscription." is displayed
 */

public class EtsySubscribeTest extends TestBase {
    @Test
    public void randomEmailSubscribeTEst(){





        /**
         *  JavascriptExecutor js = (JavascriptExecutor) driver;
         works too:
         ((JavascriptExecutor)driver).js.executeScript("window.scrollBy(0,5000)");

         js.executeScript("arguments[0].scrollIntoView(true)", enterYourEmailBox);

         another method for scrolling down all the way to bottom of window:

          -> javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)")
         */
        driver.get(ConfigurationReader.getProperty("etsy.url"));
        //called our scrollDown(); method in BrowserUtils
        BrowserUtils.scrollDown(5000);
        WebElement emailField = driver.findElement(By.name("email_address"));

        //Faker faker = new Faker(); we declared it in TestBase as a protected variable
        emailField.sendKeys(faker.internet().emailAddress()+ Keys.ENTER);


        WebElement successMSg = driver.findElement(By.cssSelector("div[class='wt-alert wt-alert--inline wt-alert--success-01 wt-text-body-01']"));

        System.out.println("successMSg.getText() = " + successMSg.getText());

        assertTrue(successMSg.isDisplayed());
        assertEquals(successMSg.getText(), "Great! We've sent you an email to confirm your subscription.");

















    }
}
