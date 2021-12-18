package com.cybertek.test_cases.vy_track_login_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginToVyTrack {


    public static void loginVyTrack(WebDriver driver) {

        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys("salesmanager102");
        driver.findElement(By.cssSelector("input[name='_password']")).sendKeys("UserUser123");
        driver.findElement(By.cssSelector("button")).click();


    }
}
