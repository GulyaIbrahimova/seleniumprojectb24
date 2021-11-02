package com.cybertek.tests.day04_locators_getattribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeDemo {

    public static void main(String[] args) throws InterruptedException {
        /*
        Locate the search field and assign to WebElement variable
        WebElement searchField = driver.findElement(By.name("q"));
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        //Locate the search field and assign to WebElement variable
        WebElement searchField = driver.findElement(By.name("q"));//WebElement interface=> WebElement represents a single element in the page
        /**
         * <input class="gLFyf gsfi" jsaction="paste:puy29d;" maxlength="2048" name="q" type="text" aria-autocomplete="both" aria-haspopup="false" autocapitalize="off" autocomplete="off" autocorrect="off" autofocus="" role="combobox" spellcheck="false" title="Search" value="" aria-label="Search" data-ved="0ahUKEwjCqsn8tO7zAhVLhuAKHcb6DbQQ39UDCAY">
         *
         */
        System.out.println("class value= " + searchField.getAttribute("class"));
        System.out.println("Max length = " +  searchField.getAttribute("maxlength"));

        //type things without using method
        searchField.sendKeys("wooden spoon");

        System.out.println("current value = " + searchField.getAttribute("value"));

        //print name value of the web element

        System.out.println("name = " + searchField.getAttribute("name"));

        Thread.sleep(3000);

        driver.close();

    }
}
