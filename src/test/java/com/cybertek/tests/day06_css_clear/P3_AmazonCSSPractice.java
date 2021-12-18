package com.cybertek.tests.day06_css_clear;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_AmazonCSSPractice {
    /**
     CSS Practice
     DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
     TC #3: Amazon link number verification
     1. Open Chrome browser
     2. Go to https://www.amazon.com/
     3. Enter search term (use cssSelector to locate search box)
     4. Verify title contains search term
     */
    public static void main(String[] args) throws InterruptedException {

        String appUrl = "https://www.amazon.com/";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(appUrl);

        /**
         <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder="" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search">
         By.cssSelector
         input[id='twotabsearchtextbox']
         input[aria-label='Search']
         input[name='field-keywords']

         */
        WebElement searchField =driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));

        /**
            <input id="nav-search-submit-button" type="submit" class="nav-input nav-progressive-attribute" value="Go" tabindex="0">

                By.cssSelector:
                input[value='Go']
                input[id='nav-search-submit-button']
         */
        WebElement searchButton = driver.findElement(By.cssSelector("input[value='Go']"));
        searchField.sendKeys("wooden spoon");
        searchButton.click();
        /**  Page refreshes at this point
             We need to locate the elements again */

        /**  Clear the search input box then search for "iphone 13 case */



       // driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).clear(); clears too

        /**  clear the search input box then search for "iphone 13 case"  */
        searchField = driver.findElement(By.cssSelector("input[aria-label='Search']"));
        searchButton = driver.findElement(By.cssSelector("input[id='nav-search-submit-button']"));
        Thread.sleep(2000);

        //clear the value of search field
        searchField.clear();
        /**  search for "iphone 13 case"  */
        searchField.sendKeys("iphone 13 wooden case");
        searchButton.click();




    }

}
