package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4_GoogleSearch {
    /*
    TC #4:	Google	search
1- Open	a	chrome	browser
2- Go	to:	https://google.com
3- Write	“apple”	in	search	box
4- Click	google	search	button
5- Verify	title:
Expected:	Title	should	start	with	“apple”	word

     */

    public static void main(String[] args) throws InterruptedException {
        ChromeDriverManager.chromedriver().setup();//polymorphism
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://www.google.com";
        driver.get(url);
        //locate and type "apple' to google search
        driver.findElement(By.name("q")).sendKeys("wooden spoon" + Keys.ENTER);//type things in the search box of Google and clikc on Search button

//        Thread.sleep(2000); can help too

        //locate and click on search button

        //driver.findElement(By.name("btnK")).click();//this way did not work, comp. is too fast, that is why ewe used Thread.sleep-> then it worked

        /**
         * if above two lines did not work, try this way:
         *driver.findElement(By.name("q")).sendKeys("wooden spoon" + Keys.ENTER);
         * driver.findElement(By.name("q")).sendKeys("wooden spoon" + Keys.ENTER);
         */

        driver.navigate().back();
        Thread.sleep(2000);//waits 2 sec
        driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER) ;

        String actTitle = driver.getTitle();
        String expTitle = "apple";

        /*
        if (actTitle.startsWith(expTitle)){

            System.out.println("PASS: Title match");
        }else{
            System.out.println("FAIL: Title mismatched");
        }

         */
        //ternary:
        System.out.println(actTitle.startsWith(expTitle)?"PASS: Title match":"\"FAIL: Title mismatched\"");




        driver.quit();





    }
}
