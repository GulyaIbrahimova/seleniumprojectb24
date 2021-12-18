package com.cybertek.tests.day07_findelements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TC0FindElements {
    /*
    1. Open Chrome browser
    2. Go to https://www.merriam-webster.com/
    3. Print out the texts of all links
    4. Print out how many link is missing text
    5. Print out how many link has text
    6. Print out how many total lin
     */

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "https://www.merriam-webster.com/";
        driver.get(url);

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("There are " + links.size() + " Links in the Website");
        int emptyLinkCounter=0;
        for (WebElement link : links) {
//            System.out.println("All link texts: " + link.getAttribute("src"));
            if(link.getText().isEmpty()){
               emptyLinkCounter++;
            }
        }
        System.out.println("Empty links: "+ emptyLinkCounter);
driver.quit();
    }
}
