package com.cybertek.tests.day18_actions_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.security.Key;

public class ActionsSendKeysTest extends TestBase {
    @Test
    public void scrollWithKeysTest(){

        driver.get(ConfigurationReader.getProperty("practice.base.url"));
        WebElement cbSchoolLink =driver.findElement(By.linkText("Cybertek School"));

        actions.moveToElement(cbSchoolLink).perform();
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();

        BrowserUtils.sleep(4);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }
    @Test
    public void rightClickTest() {
        driver.get(ConfigurationReader.getProperty("practice.base.url"));


        WebElement ab = driver.findElement(By.linkText("A/B Testing"));
        BrowserUtils.sleep(2);

        actions.moveToElement(ab).contextClick(ab).perform();
        BrowserUtils.sleep(2);
        actions.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN).click().perform();


    }
}
