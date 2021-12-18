package com.cybertek.tests.day07_findelements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ForgotPassWordFindElements {
    public static void main(String[] args) {

        String appUrl = "http://practice.cybertekschool.com/forgot_password";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get(appUrl);

        //find all links and store into list of webelements
        List<WebElement>links = driver.findElements(By.tagName("a"));

        //print out of link
        System.out.println("count of links= " + links.size());

        //print text of first one
        System.out.println("First link= " + links.get(0).getText());

        //print text of second one
        System.out.println("Second link= "+ links.get(1).getText());

        System.out.println("last link = " + links.get(links.size()-1).getText());  //-- >last link

        //loop and print href value of each one
        //iter --> enter tap
        for (WebElement link : links) {
            System.out.println(link.getAttribute("href"));
        }

        //click on HomeLink at index 1
        links.get(0).click();

        driver.quit();





    }
}
