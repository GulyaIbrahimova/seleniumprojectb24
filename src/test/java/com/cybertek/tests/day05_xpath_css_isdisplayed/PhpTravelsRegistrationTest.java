package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PhpTravelsRegistrationTest {
    public static void main(String[] args) throws InterruptedException {
        /*
        - Try to use Variables for storing all data like url, first last names, email etc
        - WebElement object variables for each element
        - Locators: use your best judgement and mix it up, apply id, name, xpath etc
        1. Add a new class PhpTravelsRegistrationTest
        2. Navigate to https://www.phptravels.net
        3. Click on Signup link on top
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2. Navigate to https://www.phptravels.net
        driver.get("https://www.phptravels.net");

        //3. Click on Signup link on top
        //<a href="https://www.phptravels.net/signup" class="theme-btn theme-btn-small waves-effect">Signup</a>
        WebElement signUp= driver.findElement(By.xpath("//a[@class='theme-btn theme-btn-small waves-effect']"));
        signUp.click();

        //4. Fill out all the information in the form and click on Signup:

        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstName.sendKeys("Gulya");

        //<input class="form-control" type="text" placeholder="Last Name" name="last_name" value="" required="">
        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastName.sendKeys("Ibrahim");

        //<input class="form-control" type="text" placeholder="Phone" name="phone" value="" required="">
        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='Phone']"));
        phone.sendKeys("858-123-4567");

        //<input class="form-control" type="text" placeholder="Email" name="email" value="" required="">
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        email.sendKeys("Gulya@gmail.com");

        //<input class="form-control" type="password" placeholder="Password" name="password" value="" required="">
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("123456"+ Keys.ENTER);

        Thread.sleep(4000);

        //5. Verify the title is “Login - PHPTRAVELS”
        String actTitle =driver.getTitle();
        if (actTitle.equals("Login - PHPTRAVELS")){
            System.out.println("Pass: Title is match");
        }else {
            System.out.println("Fail: Title is mismatch");
        }
        Thread.sleep(2000);
        //6. Enter same login information that you used during registration and click login:
        //<input class="form-control" type="email" placeholder="Email" required="required" name="email">
        WebElement emailLogin = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        emailLogin.sendKeys("Gulya@gmail.com");
        WebElement passwordLogin = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordLogin.sendKeys("123456"+Keys.ENTER);
        Thread.sleep(2000);

        //<span style="text-transform:capitalize">Gulya</span>
        String welcomeMsg = driver.findElement(By.tagName("h2")).getText();

        System.out.println(welcomeMsg.contains("Gulya")?"Pass: Welcome message contains Gulya": "Fail: Welcome message does not contain First Name");

        Thread.sleep(2000);
        driver.quit();













    }
}
