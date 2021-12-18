package com.cybertek.tests.day07_findelements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorAddTestV2 {
    public static void main(String[] args) {
        String appUrl="https://www.calculator.net";
        int num1 = 7, num2 = 4, expectedResult = num1+num2;
        /**
         Homework:

         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);

        System.out.println("//[.='"+ num1+ "']");
        WebElement num1Element = driver.findElement(By.xpath("//span[.='"+ num1+"']"));
        WebElement num2Element = driver.findElement(By.xpath("//span[.='"+ num2+"']"));
        WebElement plus = driver.findElement(By.xpath("//span[.= '+']"));
        WebElement equal = driver.findElement(By.xpath("//span[.='=']"));

        num1Element.click();
        plus.click();
        num2Element.click();
        equal.click();
        WebElement result = driver.findElement(By.cssSelector("div[id = 'sciOutPut']"));
        System.out.println("result = " + result.getText());






    }
}
