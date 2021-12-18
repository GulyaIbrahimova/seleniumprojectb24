package com.cybertek.tests.day10_dropdown_alerts_iframes_windows;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;

public class CarsDotComUserCarSearchTest {

    WebDriver driver;
    String url = "https://www.cars.com";
    Select newUsedCars;
    Select make;
    Select model;
    Select price;
    Select distance;
    WebElement zipcode;


    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test(priority = 1)
    public void defaultValues(){
        String expTitle = "New Cars, Used Cars, Car Dealers, Prices & Reviews | Cars.com";
        assertEquals(driver.getTitle(), expTitle, "Title verification failed");
        WebElement icon = driver.findElement(By.xpath("//a[@class='header-logo']"));
        assertTrue(icon.isDisplayed());

        newUsedCars = new Select(driver.findElement(By.name("stock_type")));
        assertTrue(newUsedCars.getFirstSelectedOption().isSelected());

        make = new Select(driver.findElement(By.name("makes[]")));
        assertTrue(make.getFirstSelectedOption().isSelected());

        model = new Select(driver.findElement(By.name("models[]")));
        assertTrue(model.getFirstSelectedOption().isSelected());

        price = new Select(driver.findElement(By.name("list_price_max")));
        assertTrue(price.getFirstSelectedOption().isSelected());

        distance = new Select(driver.findElement(By.name("maximum_distance")));
        assertTrue(distance.getFirstSelectedOption().isSelected());

        zipcode = driver.findElement(By.id("make-model-zip"));
        String expZipcode = "92071";
        assertEquals(zipcode.getAttribute("value"),expZipcode);
    }
    @Test(priority = 2)
    public void usedTeslaSearchTest() throws InterruptedException {
        newUsedCars = new Select(driver.findElement(By.name("stock_type")));
        newUsedCars.selectByVisibleText("Used cars");

        make = new Select(driver.findElement(By.name("makes[]")));
        make.selectByValue("tesla");

        model = new Select(driver.findElement(By.name("models[]")));
        model.selectByValue("tesla-model_3");

        price = new Select(driver.findElement(By.name("list_price_max")));
        price.selectByValue("50000");

        distance = new Select(driver.findElement(By.name("maximum_distance")));
        distance.selectByVisibleText("200 miles");

        zipcode = driver.findElement(By.id("make-model-zip"));
        zipcode.clear();
        zipcode.sendKeys("22102");

        WebElement searchBox =  driver.findElement(By.className("sds-button"));
        searchBox.click();

        WebElement header = driver.findElement(By.xpath("//h1[.='Used Tesla Model 3 for sale']"));
        assertTrue(header.getText().contains("Tesla Model 3"));

        WebElement count =driver.findElement(By.xpath("(//span[@class='total-filter-count'])[2]"));
        String result= count.getText();
        result= result.substring(0, result.length()-8);
        assertTrue(Integer.parseInt(result)>200 && Integer.parseInt(result)<500);

        assertTrue(driver.findElement(By.id("model_tesla-model_3")).isSelected());
        assertFalse(driver.findElement(By.cssSelector("label[for='model_tesla-model_s']")).isSelected());
        driver.navigate().back();

        }
    @Test(priority = 3)
    public void usedTeslaAdvancedSearchTest() throws InterruptedException {
        driver.findElement(By.className("search-advanced")).click();
        assertTrue(driver.findElement(By.xpath("//h1[@class='sds-heading--1']")).isDisplayed());
        distance = new Select(driver.findElement(By.name("maximum_distance")));
        distance.selectByValue("500");
        zipcode = driver.findElement(By.id("desktop-location-zip"));
        zipcode.clear();
        zipcode.sendKeys("22102");
        Thread.sleep(3000);
        newUsedCars = new Select(driver.findElement(By.name("stock_type")));
        newUsedCars.selectByValue("used");
        Thread.sleep(3000);
        make = new Select(driver.findElement(By.name("makes[]")));
        make.selectByValue("tesla");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement model3 = driver.findElement(By.xpath("//label[@for='desktop_tesla-model_3']"));
        js.executeScript("arguments[0].click()", model3);

        WebElement modelS = driver.findElement(By.xpath("//label[@for='desktop_tesla-model_s']"));
        js.executeScript("arguments[0].click()", modelS);

        WebElement modelX = driver.findElement(By.xpath("//label[@for='desktop_tesla-model_x']"));
        js.executeScript("arguments[0].click()", modelX);

        WebElement modelY = driver.findElement(By.xpath("//label[@for='desktop_tesla-model_y']"));
        js.executeScript("arguments[0].click()", modelY);


        driver.findElement(By.xpath("//button[@class='sds-button desktop-form-button']")).click();
        assertTrue(driver.getCurrentUrl().contains("22102"));

        Select sortBy = new Select(driver.findElement(By.id("sort-dropdown")));
        assertTrue(sortBy.getFirstSelectedOption().isSelected());
        sortBy.selectByVisibleText("Lowest price");
        Thread.sleep(4000);
        System.out.println("Car title: " + driver.findElement(By.xpath("(//h2[@class='title'])[1]")).getText());
        System.out.println("Mileage: " + driver.findElement(By.xpath("(//div[@class='mileage'])[2]")).getText());
        System.out.println("Price of the lowest result: "+ driver.findElement(By.xpath("(//span[@class='primary-price'])[1]")).getText());

    }



    }

/**
 for (int i = 0; i <=4; i++) {
 WebElement element = driver.findElement(By.xpath("//div[@id='input-wrapper-desktop-models']/descendant::input["+i+"]"));
 js.executeScript("argument[0].click",element);

 }



 Practice areas: creating and setting up TestNG tests. Using TestNG annotations. Using TestNG
 assertions. Working with drop downs and checkboxes in Selenium WebDriver. Locators.
 1) Create a java class: CarsDotComUserCarSearchTest
 2) Add setUp method with @BeforeMethod annotation
 - launch browser, maximize, set up 10 seconds implicit wait, navigate to https://
 www.cars.com
 3) Add tearDown method with @AfterMethod annotation that quits the driver
 4) Add @Test method called defaultValuesTest() , ensure it runs before other tests using
 “priority = 1” property
 - assert title equals “New Cars, Used Cars, Car Dealers, Prices & Reviews | cars.com"
 - assert cars.com icon is displayed
 - locate and assert selected values of all 5 drop downs (can use
 getFirstSelectedOption().getText()):
 -> New & used cars
 -> Mitsubishi
 -> Outlander
 -> No max price
 -> 20 miles
 - assert value in zip code field equals 22039 (please change zip code according to what
 shows up for you)

 ================================
 5) Add another @Test method called usedTeslaSearchTest() , ensure it runs after above test
 using “priority = 2”
 Set values of drop down lists and zip code according to image below and click search:
 Assertions:
 - assert the main page header contains “Tesla Model 3”
 - assert results count is more than 200 and less than 500 matches
 - assert that Model 3 checkbox is checked (isSelected() )
 - assert that Model S checkbox is available and Not checked
 ================================
 */