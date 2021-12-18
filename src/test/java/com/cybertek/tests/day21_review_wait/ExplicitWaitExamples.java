package com.cybertek.tests.day21_review_wait;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaitExamples extends TestBase {

    //http://practice.cybertekschool.com/dynamic_loading/1


    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement triggerBtn =driver.findElement(By.xpath("//button[.='Start']"));
        triggerBtn.click();
        WebElement userName  = driver.findElement(By.id("username"));
        //In order to use explict wait you neeed to create wait object
        WebDriverWait wait = new WebDriverWait(driver, 10);//constructor expects parameters

        //give condition for the element that you are waiting for, for this case that I am waiting for is username

        wait.until(ExpectedConditions.visibilityOf(userName));
        userName.sendKeys("MikeSmith");
        //when we comment implicit wait to observe synchronization problem
        //elementNotInteractableException: element not interactable


    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement enableBtn = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enableBtn.click();

        //the inputBox is visible even without clicking on enable button, however the problem is about the clickability
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@type='text']"))));

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(faker.name().username());
        enableBtn.click();
        BrowserUtils.sleep(2);



    }



}
