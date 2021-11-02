package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorldPopulationXpathTask {
    /*
    Goto https://www.worldometers.info/world-population/
wait 4 seconds
Locate current world population number using relative xpath
loop from 1 to 10
    print the text of the element
    wait 1 second
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "https://www.worldometers.info/world-population/";
        driver.get(url);

        Thread.sleep(3000);
        //Locate current world population number using relative xpath
        //<div class = "maincounter-number">

        WebElement currentWordPopulation = driver.findElement(By.xpath("//div[@class='maincounter-number']"));
        for (int i = 0; i <= 10; i++) {
            Thread.sleep(1000);

            System.out.println(currentWordPopulation.getText());

        }
       /* mY way used String length
        for (int i = 0; i < currentWordPopulation.getText().length(); i++) {

            Thread.sleep(1000);

            System.out.println(currentWordPopulation.getText());
        }

        */

    }
}
