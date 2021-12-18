package com.cybertek.tests.day07_findelements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TC02FindElements_Apple {
    /*
    TC #02: FINDELEMENTS_APPLE
    1. Open Chrome browser
    2. Go to https://www.apple.com
    3. Click to iPhone
    4. Print out the texts of all links
    5. Print out how many link is missing text
    6. Print out how many link has text
    7. Print out how many total lin
     */

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "https://www.apple.com";
        driver.get(url);
        WebElement iPhone = driver.findElement(By.cssSelector("a[class='ac-gn-link ac-gn-link-iphone']"));
        iPhone.click();
        /** 4. Print out the texts of all links*/
        List<WebElement> links = driver.findElements(By.tagName("a"));

        int linkCounter=0;
        int emptyLinkCounter=0;

        for (WebElement link : links) {
            System.out.println("link = " + link.getText());
            if (!link.getText().isEmpty()){
                linkCounter++;
            }else{
                emptyLinkCounter++;
            }
        }
        System.out.println("Total links: " + links.size());
        System.out.println("Available Links: " + linkCounter);
        System.out.println("Missing links: " + emptyLinkCounter);
        driver.quit();


    }
}
