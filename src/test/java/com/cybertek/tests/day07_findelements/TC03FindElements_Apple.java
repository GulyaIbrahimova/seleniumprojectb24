package com.cybertek.tests.day07_findelements;

import com.cybertek.utils.LinkCounter;
import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TC03FindElements_Apple {
    /*
    TC #03: FINDELEMENTS_APPLE
1. Open Chrome browser
2. Go to https://www.apple.com
3. Click to all of the headers one by one
a. Mac, iPad, iPhone, Watch, TV, Music, Support
4. Print out the titles of the each page
5. Print out total number of links in each page
6. While in each page:
a. Print out how many link is missing text TOTAL
b. Print out how many link has text TOTAL
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "https://www.apple.com";
        driver.get(url);

        /** Mac */
        WebElement macHeader = driver.findElement(By.xpath("//a[@href='/mac/']"));
        macHeader.click();
        System.out.println("actual title: "+ driver.getTitle());
        List<WebElement> macHeaderLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links for Mac: "+ macHeaderLinks.size());
        LinkCounter.linkCounter(macHeaderLinks);

        /**  Ipad*/
        WebElement iPadHeader = driver.findElement(By.xpath("//a[@href='/ipad/']"));
        iPadHeader.click();
        System.out.println("actual title: "+ driver.getTitle());

        List<WebElement> iPadHeaderLinks = driver.findElements(By.tagName("a"));
       LinkCounter.linkCounter(iPadHeaderLinks);
        /** Iphone  */
        WebElement iPhoneHeader = driver.findElement(By.xpath("//a[@href='/iphone/']"));
        iPhoneHeader.click();
        System.out.println("actual" + " title: "+ driver.getTitle());

        List<WebElement> iPhoneHeaderLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links for Iphone: "+ iPhoneHeaderLinks.size());
        LinkCounter.linkCounter(iPhoneHeaderLinks);

        /** Watch  */

        WebElement watchHeader = driver.findElement(By.xpath("//a[@href='/watch/']"));
        watchHeader.click();
        System.out.println("actual" + " title: "+ driver.getTitle());

        List<WebElement> watchHeaderLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links for Watch: "+ macHeaderLinks.size());
        LinkCounter.linkCounter(watchHeaderLinks);

        /** Support */
        WebElement supportHeader = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-support']"));
        supportHeader.click();
        System.out.println("actual title: "+ driver.getTitle());

        List<WebElement> supportHeaderLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links for Support: "+ macHeaderLinks.size());
       LinkCounter.linkCounter(supportHeaderLinks);

        /** TV */

        WebElement tv = driver.findElement(By.xpath("//a[@href='https://www.apple.com/tv/']"));
        tv.click();
        System.out.println("actual title: "+ driver.getTitle());
        List<WebElement> tvHeaderLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links for TV: "+ macHeaderLinks.size());
        LinkCounter.linkCounter(tvHeaderLinks);

        driver.navigate().back();

        /** Music */
        WebElement music = driver.findElement(By.xpath("//a[@href='https://www.apple.com/music/']"));
        music.click();
        System.out.println("actual title: "+ driver.getTitle());

        List<WebElement> musicHeaderLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links for Music: "+ macHeaderLinks.size());
        LinkCounter.linkCounter(musicHeaderLinks);

        driver.quit();

    }
    }

