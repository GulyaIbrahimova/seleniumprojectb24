package com.cybertek.tests.day07_findelements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorHomework {
    public static void main(String[] args) throws InterruptedException {
        String appUrl = "https://www.calculator.net";
        int num1 = 128, num2 = 90;
        /**
         Homework: make selenium work for numbers more than 1 digit as well
         int num1 = 128, num2 = 90; etc
         */
        int expectedResult = num1 + num2;

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);
        String numOne = num1 + "";
        String numTwo = num2 + "";

        for (int i = 0; i < numOne.length(); i++) {
           driver.findElement(By.xpath("//span[.='" + numOne.charAt(i) + "']")).click();

        }
        Thread.sleep(1234);
        WebElement plus = driver.findElement(By.xpath("//span[.= '+']"));
        plus.click();

        for (int i = 0; i < numTwo.length(); i++) {
            driver.findElement(By.xpath("//span[.='" + numTwo.charAt(i) + "']")).click();
        }
        Thread.sleep(1234);
        WebElement equals = driver.findElement(By.xpath("//span[.='=']"));
        equals.click();
        WebElement result = driver.findElement(By.xpath("//div[@id='sciOutPut']"));
        System.out.println("Result = " + result.getText());

        driver.quit();

    }
}

