package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC5_SmartBearLoginTest {

    public static void main(String[] args) throws InterruptedException {
        /*
        TC #5:	Basic	login	authentication
			1- Open	a	chrome	browser
			2- Go	to:
			http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
			3- Verify	title	equals:
			Expected:	Web	Orders	Login
			4- Enter	username:	Tester
			5- Enter	password:	test
			6- Click	“Sign	In”	button
			7- Verify	title equals:
			Expected:	Web	Order

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();//WebDriver is interface => is like abstraction, all how to parts stored in ChromeDriver. ChromeDriver is a class
        driver.manage().window().maximize();

        String appUrl = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
        driver.get(appUrl);

        //always good to store into variables
        String userName = "Tester";
        String passWord = "test";

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(userName+ Keys.ENTER);
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(passWord);
        driver.findElement(By.name("ctl00_MainContent_login_button")).click();
        //When you do 'Keys',Its a class that basically replicated ur keyboard, so u can do
        //Keys.TAB, Keys.CTRL, Keys.ALT, hen you can combo them= Keys.CTRL + Keys.Shift

        //verify title is "Web Orders"
//  Thread.sleep(2000);

        String expectedTitle = "Web Orders";
        String actualTitle = driver.getTitle();

        System.out.println(actualTitle.equals(expectedTitle)? " PASS: Title match. login success.": "FAIL:  Title mismatch. Login failed");

        //or System.out.println(actualTitle.equals(expectedTitle)? " PASS: Title match": "FAIL: login failed. Title mismatch" );
        //click on logout
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_logout")).click();

        driver.quit();


    }


}
