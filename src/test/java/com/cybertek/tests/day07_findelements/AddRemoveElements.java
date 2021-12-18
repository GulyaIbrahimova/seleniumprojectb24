package com.cybertek.tests.day07_findelements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddRemoveElements {
    /**
    TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements
3. Click to “Add Element” button 50 times
4. Verify 50 “Delete” button is displayed after clicking.
5. Click to ALL “Delete” buttons to delete them.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
     */

    public static void main(String[] args) {

        String appUrl = "http://practice.cybertekschool.com/add_remove_elements/";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);

        //locate nad click add element button 50 times
        WebElement addElement = driver.findElement(By.cssSelector("button[onclick= 'addElement()'"));////button[text() ='Add Element']

        for (int i = 0; i < 50; i++) {
            addElement.click();
        }
        System.out.println(addElement.isDisplayed());
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//Button[@class='added-manually']"));

        System.out.println("Count of delete buttons= " + deleteButtons.size());
        if (deleteButtons.size()==50){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }
        System.out.println(deleteButtons.size());
        //click all delete buttons to remove them

        //with lambda
        deleteButtons.forEach(deleteBtn->deleteBtn.click());
        //the same as for Each loop
       /* for (WebElement deleteBtn : deleteButtons) {
            deleteBtn.click();
        }

        */
        //run findElements for delete buttons again and see if it is 0
        deleteButtons = driver.findElements(By.xpath("//Button[@class='added-manually']"));
        if (deleteButtons.size()==0){
            System.out.println("Pass: All 50 buttons deleted successfully");
        }else {
            System.out.println("Fail: Couldn't delete all 50 buttons");
        }

    }
}
