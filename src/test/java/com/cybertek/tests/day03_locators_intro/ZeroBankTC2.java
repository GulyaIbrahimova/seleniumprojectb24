package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankTC2 {
    /*
    TC #2: Zero Bank link text verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify link text from top left:
Expected: “Zero Bank”
4. Verify link href attribute value contains:
Expected: “index.html”
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String appUrl = "http://zero.webappsecurity.com/login.html";
        driver.get(appUrl);

        //<a href="/index.html" class="brand">Zero Bank</a>. This links classname is brand.

        String textOfLink = driver.findElement(By.className("brand")).getText();//Saying find element by using class name
        System.out.println("textOfLink = " + textOfLink);

        if (textOfLink.equals("Zero Bank")){
            System.out.println("PASS: links text matched");
        }else{
            System.out.println("FAIL: Links text mismatched");
        }

        String href = driver.findElement(By.className("brand")).getAttribute("href");//another way with getAttribute
        System.out.println("href = " + href);

        driver.quit();


    }

}
