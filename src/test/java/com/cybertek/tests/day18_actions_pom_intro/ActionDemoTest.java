package com.cybertek.tests.day18_actions_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.security.auth.login.Configuration;
import java.util.List;

public class ActionDemoTest extends TestBase {

    @Test
    public void hoverElementTest(){

        driver.get(ConfigurationReader.getProperty("hover.url"));
        WebElement image1 = driver.findElement(By.xpath("//div/img[1]"));//xpath-> (img)[1]

        //create Actions class objects to be able to hover over the image

        Actions actions = new Actions(driver);

        //hover over img1
        actions.moveToElement(image1).perform();//in order to run it we need to .perform

        BrowserUtils.sleep(2);

        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        actions.moveToElement(img2).perform();

        WebElement img3 = driver.findElement(By.xpath("(//img)[2]"));
        actions.moveToElement(img3).perform();

    }


    @Test
    public void hoverOverGroupOfElements() {
        driver.get(ConfigurationReader.getProperty("hover.url"));
        List<WebElement> images = driver.findElements(By.xpath("//div/img"));

        for (WebElement image : images) {

            actions.moveToElement(image).perform();
        }

        /**
         with lambda:
         images.forEach(eachImg ->actions.moveToElement(eachImg).perform());


         */
    }
    @Test

    public void hoverThroughGoogle(){

        driver.get(ConfigurationReader.getProperty("google.url"));
        WebElement googleSearch = driver.findElement(By.xpath("//div[@class= 'FPdoLc lJ9FBc']//input[@value='Google Search']"));
        WebElement feelingLuckyBtn = driver.findElement(By.cssSelector("#gbqfbb"));

        for (int i = 0; i <=5; i++) {

            actions.moveToElement(feelingLuckyBtn).perform();
            BrowserUtils.sleep(1);
            actions.moveToElement(googleSearch).perform();
            BrowserUtils.sleep(1);

        }


    }
}
