package com.cybertek.tests.day18_actions_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsDoubleClickTest extends TestBase {

    @Test
    public void doubleClickForColorChange() {

        driver.get(ConfigurationReader.getProperty("doubleclick.url"));
        driver.switchTo().frame("iframeResult");

        WebElement text = driver.findElement(By.id("demo"));

        System.out.println("text = " + text.getText());

        //double click to see color change
        actions.doubleClick(text).perform();
        System.out.println("style of text is = " + text.getAttribute("style"));

        Assert.assertTrue(text.getAttribute("style").contains("red"));

        driver.switchTo().defaultContent();











    }
}