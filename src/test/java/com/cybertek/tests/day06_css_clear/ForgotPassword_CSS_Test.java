package com.cybertek.tests.day06_css_clear;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword_CSS_Test {
    public static void main(String[] args) throws InterruptedException {

        String appUrl = "http://practice.cybertekschool.com/forgot_password";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get(appUrl);

        /**
         <input type="text" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required="">
         input[type='text'] instead
         use name: input[name='email']
         */
        WebElement emailField = driver.findElement(By.cssSelector("input[name='email']"));
        emailField.sendKeys("student1@gmail.com");
        //wait a second and type > different email
        Thread.sleep(1000);
        emailField.clear();
        emailField.sendKeys("student2@gmail.com");
        //can use of method too:  emailField.sendKeys(RandomEmailGenerator.emailGenerator());

        //loop

        for (int i = 1; i < 10; i++) {
            Thread.sleep(1000);
            emailField.clear();
            emailField.sendKeys("student" + i + "@gmail.com");

        }
    }
}
