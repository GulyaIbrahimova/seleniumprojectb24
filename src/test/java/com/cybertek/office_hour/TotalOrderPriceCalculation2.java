package com.cybertek.office_hour;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

public class TotalOrderPriceCalculation2 {
    /**
     Total Order Price Calculation 2
     - Go to https://www.demoblaze.com/index.html#
     - From Categories select Laptops, and from products select Sony Vaio i7
     - click Add to Cart then handle pop up
     - Navigate to Home
     - From Categories select Phones, and from products select Iphone 6 32gb
     - click Add to Cart then handle pop up
     - Navigate to Cart
     - Then Verify that total cart price is equal to expected (total of added 2 items) price
     */

    WebDriver driver;
    String url = "https://www.demoblaze.com/index.html#";
    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void TC2() throws InterruptedException {
        driver.findElement(By.xpath("//a[.='Laptops']")).click();
        driver.findElement(By.linkText("Sony vaio i7")).click();
        driver.findElement(By.linkText("Add to cart")).click();

        Thread.sleep(4000);
        Alert popUpMsg = driver.switchTo().alert();
        popUpMsg.accept();
        /** navigate back home*/
        driver.navigate().to(url);

        driver.findElement(By.linkText("Phones")).click();
        driver.findElement(By.linkText("Iphone 6 32gb")).click();
        driver.findElement(By.linkText("Add to cart")).click();

        Thread.sleep(3000);
        Alert alertMsg = driver.switchTo().alert();
        alertMsg.accept();

        driver.findElement(By.linkText("Cart")).click();
        WebElement total = driver.findElement(By.xpath("//h3[.='1580']"));

        WebElement item1 = driver.findElement(By.xpath("//tbody/tr[1]/td[3]"));
        WebElement item2 = driver.findElement(By.xpath("//tbody/tr[2]/td[3]"));
        String expectedTotal = Integer.parseInt(item1.getText()) + Integer.parseInt(item2.getText())+"";
        assertEquals(total.getText(),expectedTotal);
        Thread.sleep(3000);
        System.out.println("item1 = " + item1.getText());
        System.out.println("item2 = "+ item2.getText());
        System.out.println("expectedTotal = " + expectedTotal);
        System.out.println("total = " + total.getText());















    }
}
