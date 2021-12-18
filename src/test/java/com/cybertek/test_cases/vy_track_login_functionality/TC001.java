package com.cybertek.test_cases.vy_track_login_functionality;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class TC001 {
    String url = "https://qa2.vytrack.com/user/login";
    WebDriver driver;//can use in every method


    @BeforeMethod
    public void setUp() {
        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);

    }

    @Test
    public void TC1() {
       LoginToVyTrack.loginVyTrack(driver);
        String expectedTitle = "Dashboard";
        String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle,expectedTitle, "Pass: Login functionality was successful");

    }

    @Test
    public void TC2() {
        WebElement userName=driver.findElement(By.xpath("//input[@name='_username']"));
        WebElement passWord = driver.findElement(By.cssSelector("input[name='_password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("button"));

        userName.sendKeys("salesmanager102");
        passWord.sendKeys("1234");
        loginButton.click();

        String expPopUpMsg ="Invalid user name or password.";
        WebElement msg = driver.findElement(By.xpath("//div[text()='Invalid user name or password.']"));
        String actTPopUpMsg=msg.getText();
        if (expPopUpMsg.equals(actTPopUpMsg)){
            System.out.println("Pass: Invalid login");
        }else{
            System.out.println("Fail: Login verification failed");
        }
    }
    @Test
    public void TC3(){
        WebElement userName=driver.findElement(By.xpath("//input[@name='_username']"));
        WebElement passWord = driver.findElement(By.cssSelector("input[name='_password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("button"));
        userName.sendKeys("abcd");
        passWord.sendKeys("UserUser123");
        loginButton.click();

        String expPopUpMsg ="Invalid user name or password.";
        WebElement msg = driver.findElement(By.xpath("//div[text()='Invalid user name or password.']"));
        String actTPopUpMsg=msg.getText();
        if (expPopUpMsg.equals(actTPopUpMsg)){
            System.out.println("Pass: Invalid login");
        }else{
            System.out.println("Fail: Login verification failed");
        }
    }
    @Test
    public void TC4(){
        WebElement userName=driver.findElement(By.xpath("//input[@name='_username']"));
        WebElement passWord = driver.findElement(By.cssSelector("input[name='_password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("button"));
        userName.sendKeys("abcd");
        passWord.sendKeys("1234");
        loginButton.click();

        String expPopUpMsg ="Invalid user name or password.";
        WebElement msg = driver.findElement(By.xpath("//div[text()='Invalid user name or password.']"));
        String actTPopUpMsg=msg.getText();
        if (expPopUpMsg.equals(actTPopUpMsg)){
            System.out.println("Pass: Invalid login");
        }else{
            System.out.println("Fail: Login verification failed");
        }
    }

    }

