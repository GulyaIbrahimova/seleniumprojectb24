package com.cybertek.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SmartBearUtils {
    //
    public static void loginToSmartBear(WebDriver driver){
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
        Assert.assertEquals(driver.getTitle(), "Web Orders");

    }
    public static void AddProduct(WebDriver driver){

        driver.findElement(By.linkText("Order")).click();
// Select familyAlbum from product,set quantity 2
        Select product = new Select(driver.findElement(By.name("ctl00$MainContent$fmwOrder$ddlProduct")));
        product.selectByValue("FamilyAlbum");
        WebElement quantity = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
        quantity.clear();
        quantity.sendKeys("2");
        driver.findElement(By.className("btn_dark")).click();

        System.out.println("total = " + driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtTotal")).getAttribute("value"));
    }
}
