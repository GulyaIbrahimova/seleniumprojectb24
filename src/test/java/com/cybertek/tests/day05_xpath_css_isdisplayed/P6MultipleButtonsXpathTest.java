package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P6MultipleButtonsXpathTest {
    /*
    TC #6: XPATH LOCATOR practice
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/multiple_buttons
    3. Click on Button 1
    4. Verify text displayed is as expected:
    Expected: “Clicked on button one!”
    USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
     */
    public static void main(String[] args) {

        String appUrl = "http://practice.cybertekschool.com/multiple_buttons";
        //   1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //   2. Go to http://practice.cybertekschool.com/multiple_buttons
        driver.get(appUrl);

        //   3. Click on Button 1

        //xpath=> <button class="btn btn-primary" onclick="button1()">Button 1</button>
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();

        // 4. Verify text displayed is as expected:
        //    Expected: “Clicked on button one!”

        //<p id="result" style="color:green">Clicked on button one!</p>
        WebElement resultMsg = driver.findElement(By.xpath("//p[@id='result']"));
        System.out.println(resultMsg.getText());

        //locate button2 using xpath and check if it is currently displayed on the page,then click on it

        //<button class="btn btn-primary" onclick="button2()" name="button2">Button 2</button>

        WebElement button2 = driver.findElement(By.xpath("//button[text()='Button 2']"));//text is not a attribute . it is a method to bring text of tag

        if (button2.isDisplayed()){
            System.out.println("Pass: Button2 is displayed");
            button2.click();
        }else {
            System.out.println("Fail: Button2 is not displayed");
        }

    }
}
