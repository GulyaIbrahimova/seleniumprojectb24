package com.cybertek.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RandomEmailGenerator {

    public static String emailGenerator() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://generator.email");

        WebElement first = driver.findElement(By.id("email_ch_text"));

        String email = first.getText();

        driver.quit();

        return email;

    }

}
