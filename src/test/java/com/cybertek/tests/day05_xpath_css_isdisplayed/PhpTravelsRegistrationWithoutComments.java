package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.RandomEmailGenerator;
import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PhpTravelsRegistrationWithoutComments {
    public static void main(String[] args) throws InterruptedException {

        String randomEmail = RandomEmailGenerator.emailGenerator();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net");

        WebElement signUp= driver.findElement(By.xpath("//a[@class='theme-btn theme-btn-small waves-effect']"));
        signUp.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstName.sendKeys("Gulya");

        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastName.sendKeys("Ibrahim");

        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='Phone']"));
        phone.sendKeys("858-123-4567");

        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        email.sendKeys(randomEmail);

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("123456"+ Keys.ENTER);


        Thread.sleep(2000);

        String actTitle =driver.getTitle();
        if (actTitle.equals("Login - PHPTRAVELS")){
            System.out.println("Pass: Title is match");
        }else {
            System.out.println("Fail: Title is mismatch");
        }
        WebElement emailLogin = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        emailLogin.sendKeys(randomEmail);
        WebElement passwordLogin = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordLogin.sendKeys("123456"+Keys.ENTER);
        Thread.sleep(2000);

        String welcomeMsg = driver.findElement(By.tagName("h2")).getText();

        System.out.println(welcomeMsg.contains("Gulya")?"Pass: Name verification passed": "Fail: Welcome message does not contain First Name");

        Thread.sleep(2000);
        //driver.quit();
}}
