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
    driver.switchTo().alert().accept();

    }
    @Test
    public void waitForButtonEnabledTest(){

        WebElement button = driver.findElement(By.id("disable"));
        System.out.println("cher cher button enabled = " + button.isEnabled());//false

        //click on enable button
        WebElement enableButton = driver.findElement(By.id("enable-button"));
        enableButton.click();
        //create wait until the button is enabled
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(button));
        System.out.println("cher cher button enabled = " + button.isEnabled());
    }
    @Test
    public void waitForCheckboxIsChecked(){
        WebElement checkbox = driver.findElement(By.id("ch"));

        System.out.println("checkbox is checked "+ checkbox.isSelected());
        WebElement enableCheckboxButton = driver.findElement(By.id("checkbox"));
        enableCheckboxButton.click();
        //wait until checkbox is selected
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeSelected(checkbox));
        System.out.println("checkbox is checked "+ checkbox.isSelected());



    }
}
