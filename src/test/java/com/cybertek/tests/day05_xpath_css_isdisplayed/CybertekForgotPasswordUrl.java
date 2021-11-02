package com.cybertek.tests.day05_xpath_css_isdisplayed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CybertekForgotPasswordUrl {
    /*
    TC #3: PracticeCybertek/ForgotPassword URL verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password
3. Enter any email into input box
4. Click on Retrieve password
5. Verify URL contains:
Expected: “email_sent”
6. Verify textbox displayed the content as expected.
Expected: “Your e-mail’s been sent!”
Hint: You need to use getText method for this practice
     */
    public static void main(String[] args) throws InterruptedException {


        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //maximize window
        driver.manage().window().maximize();


       // 2. Go to http://practice.cybertekschool.com/forgot_password
        String url = "http://practice.cybertekschool.com/forgot_password";
        driver.get(url);

        //3. Enter any email into input box
        driver.findElement(By.name("email")).sendKeys("mcuban@gmail.com");


        //4. Click on Retrieve password
       driver.findElement(By.className("radius")).click();

       // or driver.findElement(By.name("email")).sendKeys("mcuban@gmail.com" + Keys.ENTER);

       //5. Verify URL contains:
        //Expected: “email_sent”

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "email_sent";

        if (currentUrl.contains(expectedUrl)){
            System.out.println("PASS: email_sent url verified");
        }else {
            System.out.println("Fail: email_sent url verified");
        }
        System.out.println("currentUrl = " + currentUrl);

        //6. Verify textBox displayed the content as expected.

        //Expected: “Your e-mail’s been sent!”
        //String message = driver.findElement(By.tagName("h4")).getText();
        //or can be by name too:
       // driver.findElement() can be stored as a WebElement for reusability and we cannot store it in String unless we use driver.findElement().getText() and maybe other methods that brings Strings
        WebElement message = driver.findElement(By.name("confirmation_message"));
        //System.out.println("message = " + message.getText());

        String expMessage = "Your e-mail’s been sent!";
        String actMessage = message.getText();

        //get Attribute name:
        System.out.println("Name attribute value of message element= " + message.getAttribute("name"));

        if (actMessage.equalsIgnoreCase(expMessage)){
            System.out.println("PASS: ");
        }else{
            System.out.println("Fail: ");
        }

        driver.quit();











    }
}
