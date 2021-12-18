package com.cybertek.tests.day08_implicitwait_checkbox_radio_testng;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * Launch Browser and goto etsy homepage
 * search for wooden spoon
 * click on filters
 * Select free shipping, on sale
 * select under $25
 * Click on apply filters
 * Print count of results
 */
public class Etsy {
    public static void main(String[] args) throws InterruptedException {

        String url = "https://www.etsy.com/";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //implicit wait command wait up to 10 sec
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        WebElement searchBox =driver.findElement(By.name("search_query"));
        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);

        WebElement allFilters = driver.findElement(By.id("search-filter-button"));
        allFilters.click();
        /**Select free shipping, on sale
                 * select under $25*/
        WebElement freeShipping =driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']"));
        freeShipping.click();

        //on sale
        WebElement onSale = driver.findElement(By.xpath("//label[@for='special-offers-on-sale']"));
        onSale.click();

        //under 25$
        WebElement under25 = driver.findElement(By.xpath("//label[@for='price-input-1']"));
        under25.click();
//apply button
        WebElement applyButton = driver.findElement(By.xpath("//button[@aria-label='Apply']"));
        applyButton.click();

        Thread.sleep(1234);

        WebElement resultCount = driver.findElement(By.xpath("//span[contains(text(),'results,')]"));
        System.out.println(resultCount.getText());




    }
}
