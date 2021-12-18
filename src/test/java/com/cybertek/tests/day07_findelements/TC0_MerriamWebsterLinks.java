package com.cybertek.tests.day07_findelements;

import com.cybertek.utils.LinkCounter;
import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TC0_MerriamWebsterLinks {
    /**
     TC #0: FINDELEMENTS
    1. Open Chrome browser
    2. Go to https://www.merriam-webster.com/
    3. Print out the texts of all links
    4. Print out how many link is missing text
    5. Print out how many link has text
    6. Print out how many total link */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "https://www.merriam-webster.com/";
        driver.get(url);

        //Print out the texts of all links

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links for given page " + links.size());

        LinkCounter.linkCounter(links);
    }

}
