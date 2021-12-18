package com.cybertek.test_cases.vy_track_login_functionality;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TC003 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = "https://qa2.vytrack.com/user/login";
        driver.get(url);

        WebElement userName=driver.findElement(By.xpath("//input[@name='_username']"));
        WebElement passWord = driver.findElement(By.cssSelector("input[name='_password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("button"));

        userName.sendKeys("abcd");
        passWord.sendKeys("UserUser123");
        loginButton.click();

        String expPopUpMsg ="Invalid user name or password.";
        WebElement msg = driver.findElement(By.xpath("//div[text()='Invalid user name or password.']"));
        String actTPopUpMsg=msg.getText();
        if (expPopUpMsg.equals(actTPopUpMsg)){
            System.out.println("Pass: Invalid login");
        }else{
            System.out.println("Fail: Login verification failed");
        }
    }
}
