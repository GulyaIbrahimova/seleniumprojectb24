package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1ForgotPassword_xpath_css {
    /*

    TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
        1. Open Chrome browser
        2. Go to http://practice.cybertekschool.com/forgot_password
        3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        a. “Home” link
        b. “Forgot password” header
        c. “E-mail” text
        d. E-mail input box
        e. “Retrieve password” button
        f. “Powered by Cybertek School” text
        4. Verify all WebElements are displayed.
     */
    public static void main(String[] args) {
        String appUrl = "http://practice.cybertekschool.com/forgot_password";
        //   1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //   2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get(appUrl);

        //3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)

         //<a class="nav-link" href="/">Home</a>
        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        System.out.println(homeLink.isDisplayed());


        //<h2>Forgot Password</h2>
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        System.out.println(forgotPasswordHeader.isDisplayed());

        //<label for="email">E-mail</label>
        WebElement emailLabel = driver.findElement(By.xpath("//label[@for='email']"));
        System.out.println(emailLabel.isDisplayed());

        //<input type="text" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required="">
        WebElement emailField = driver.findElement(By.xpath("//input[@type='text']"));

        //<i class="icon-2x icon-signin">Retrieve password</i>
        WebElement retrievePassword= driver.findElement(By.xpath("//i[text()='Retrieve password']"));

        //<a target="_blank" href="https://cybertekschool.com/">Cybertek School</a>
        WebElement poweredByLabel =  driver.findElement(By.xpath("//a[text() = 'Cybertek School']"));;

        /*

        if you need to search multiple attributes to track down a locator, you can use "and" like this:
            driver.findElement(By.xpath("//button[@id='form_submit' and @type='submit']"));


         */



    }
}
