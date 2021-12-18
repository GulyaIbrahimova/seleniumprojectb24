package com.cybertek.tests.day07_findelements;

/*
  1) Add a class CalculatorAddTest

    2) Declare variables String appUrl = “https://www.calculator.net”
    int num1 = 5, num2 = 3
    int expectedResult = 8
    3) Launch selenium, maximize and navigate to the url
     */


import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorAddTest {
    public static void main(String[] args) throws InterruptedException {
        String appUrl = "https://www.calculator.net";
        int num1 = 5, num2 = 3, expectedResult = 8;

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);

        /** 4) Locate 4 elements “5”, “3”, “+” , “=” using css or xpath and store into WebElement objects */

        WebElement num1Elements = driver.findElement(By.cssSelector("span[onclick='r(5)']"));
        WebElement num2Element = driver.findElement(By.cssSelector("span[onclick='r(3)']"));
        WebElement plusSign = driver.findElement(By.xpath("//span[.= '+']"));
        WebElement equalSign = driver.findElement(By.xpath("//span[.='=']"));
        num1Elements.click();
        Thread.sleep(1234);
        plusSign.click();
        Thread.sleep(1234);
        num2Element.click();
        Thread.sleep(1234);
        equalSign.click();

        WebElement result = driver.findElement(By.cssSelector("div[id = 'sciOutPut']"));
        System.out.println(num1+"+" + num2 + "="+ result.getText());

        String resultValue = result.getText();
        //get rid off right/left spaces
        resultValue=resultValue.trim();


       //convert to int
        int actualResult = Integer.parseInt(resultValue);
        if(actualResult == expectedResult){
            System.out.println("Pass: Calculation match");
        }else{
            System.out.println("Fail: Calculation mismatch");
        }

        driver.quit();



    }
}
