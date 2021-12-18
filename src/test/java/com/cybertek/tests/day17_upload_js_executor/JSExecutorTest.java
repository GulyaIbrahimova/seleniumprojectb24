package com.cybertek.tests.day17_upload_js_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutorTest extends TestBase {

    @Test
    public void alertExampleTest(){
        //down casting from WebDriver to JavaScriptExecutor interface
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //running javascript alert command
        js.executeScript("alert('hello,hello!')");
        BrowserUtils.sleep(2);
        Alert alert = driver.switchTo().alert();
        System.out.println("alert = " + alert.getText());
        alert.accept();

    }
    @Test
    public void scrollTest(){
        driver.get(ConfigurationReader.getProperty("scroll.url"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        BrowserUtils.sleep(2);
        js.executeScript("window.scrollBy(0, 5000)");

        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(2);
            js.executeScript("window.scrollBy(0, 5000)");


        }



    }
    @Test
    public void scrollToElementTest(){
        driver.get(ConfigurationReader.getProperty("tesla.url"));

       // locate model y element
        WebElement modelYLabel = driver.findElement(By.xpath("(//h1[.='Model Y'])[1]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", modelYLabel);
        BrowserUtils.sleep(2);

        WebElement contactLink = driver.findElement(By.xpath("//a[@href='/contact']"));
        js.executeScript("arguments[0].scrollIntoView(true)", contactLink);

        WebElement shopNow = driver.findElement(By.xpath("//a[@title='Shop Now']"));
        js.executeScript("arguments[0].scrollIntoView(true)" , shopNow);


        WebElement allDown = driver.findElement(By.xpath("(//h1[.='Accessories'])[1]"));
        js.executeScript("arguments[0].scrollIntoView(true)", allDown);

    }
    @Test
    public void loginFacebook(){
        driver.get(ConfigurationReader.getProperty("facebook.url"));
        WebElement userName = driver.findElement(By.name("email"));
        WebElement passWord = driver.findElement(By.id("pass"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='hello.@gmail.com'", userName);
        js.executeScript("arguments[0].value='Abcds1234'", passWord);

    }
}
