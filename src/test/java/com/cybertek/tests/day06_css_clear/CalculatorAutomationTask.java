package com.cybertek.tests.day06_css_clear;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorAutomationTask {
    /**
     Try to use CSS or Xpath for this task.
     You are writing an automation test to verify if the calculator is working as expected.
     1) Add a class CalculatorAddTest
     2) Declare variables String appUrl = “https://www.calculator.net”
     int num1 = 5, num2 = 3
     int expectedResult = 8
     3) Launch selenium, maximize and navigate to the url
     */
    public static void main(String[] args) throws InterruptedException {
        String appUrl="https://www.calculator.net";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);

        /**  4) Locate 4 elements “5”, “3”, “+” , “=” using css or xpath and store into WebElement
         object */
        WebElement num5 = driver.findElement(By.cssSelector("span[onclick = 'r(5)']"));
        WebElement num3 = driver.findElement(By.cssSelector("span[onclick = 'r(3)']"));
        WebElement plusSign = driver.findElement(By.cssSelector("span[class = 'sciop']"));
        WebElement equalSign = driver.findElement(By.cssSelector("span[onclick=\"r('=')\"]"));

        /**  5) Click the elements in right order as you would do normally,
         Add Thread.sleep(1234) in between steps to slow it down a little - not needed if you
         have a cheap computer like mine :) */
        num5.click();
        Thread.sleep(1234);
        plusSign.click();
        Thread.sleep(1234);
        num3.click();
        Thread.sleep(1234);
        equalSign.click();
        /**  6) Locate result area and store into webElement object*/

       //<div id="sciOutPut">&nbsp;8</div>
        WebElement result = driver.findElement(By.cssSelector("div[id = 'sciOutPut']"));
        System.out.println("result= " + result.getText().trim());

        /**  7) Read the text of the result element, remove any unneeded characters and convert
            into int. int expectedResult = Integer.parseInt(result);*/

        int expectedResult = Integer.parseInt(result.getText().trim());
        int actualResult = 8;
        /**  8) compare actualResult and the expectedResult . print pass or fail */
        if (actualResult == expectedResult){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }
        /** 9) Quit selenium and go home :))*/
        driver.quit();










    }
}
