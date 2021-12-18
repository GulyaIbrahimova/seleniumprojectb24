package com.cybertek.tests.day08_implicitwait_checkbox_radio_testng;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtonTest {
    public static void main(String[] args) throws InterruptedException {
        String url = "http://practice.cybertekschool.com/radio_buttons";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //implicit wait command wait up to 10 sec
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        WebElement redBox= driver.findElement(By.id("red"));

        //can work without {} when u have only 1 statement
        if(!redBox.isSelected()) redBox.click();

        WebElement basketballBox= driver.findElement(By.id("basketball"));
        if (!basketballBox.isSelected()) basketballBox.click();

        if (basketballBox.isSelected()){
            System.out.println("Pass - basketball is selected");
        }else{
            System.out.println("FAil - basketball is not selected");
        }

        //to click all the color buttons
        List<WebElement> allColorButtons = driver.findElements(By.name("color"));
        allColorButtons.forEach(WebElement::click);

        /** 1.find all radio buttons
            2. print the count
            3. click one by one , waiting 1 second in between
            4. we can use isEnabled method to check if element is active/disabled  */

            List<WebElement> allRadioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        System.out.println("Total count of radio buttons: " + allRadioButtons.size());
        for (WebElement eachRadioButton : allRadioButtons) {
            if (eachRadioButton.isEnabled()){
                eachRadioButton.click();
                Thread.sleep(1234);

            }

        }
        driver.quit();






    }
}
