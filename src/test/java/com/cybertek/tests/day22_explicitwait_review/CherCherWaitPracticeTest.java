package com.cybertek.tests.day22_explicitwait_review;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CherCherWaitPracticeTest extends TestBase {

    /**because we repeat this step in every test we can add BeforeMethod
     TestBase BeforeMethod will run 1st, then child class BeforeMethod will run
     */
    @BeforeMethod
    public void goToHomePage(){
        driver.get(ConfigurationReader.getProperty("chercher.url"));
    }
    @Test
    public void waitForAlertTest(){
       WebElement openAlertButton =  driver.findElement(By.cssSelector("#alert"));
       openAlertButton.click();
        WebDriverWait wait =  new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @Test
    public void waitForButtonEnabledTest(){

    }
    @Test
    public void waitForCheckboxIsChecked(){

    }
}
