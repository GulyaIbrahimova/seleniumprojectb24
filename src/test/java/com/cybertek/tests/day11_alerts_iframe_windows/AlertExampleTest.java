package com.cybertek.tests.day11_alerts_iframe_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
import static com.cybertek.utils.WebDriverFactory.getDriver;

public class AlertExampleTest {

    WebDriver driver;
    String url ="http://practice.cybertekschool.com/javascript_alerts";

@BeforeMethod
    public void setUp(){
    driver = getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(url);
}
@AfterMethod
public void tearDown(){
    driver.quit();
}

@Test
    public void infoAlertTest(){
    //click on JS alert link

    WebElement alertLink = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));//or //button[1]
    alertLink.click();

    Alert infoAlert = driver.switchTo().alert();
    System.out.println("Text of JS alert = " + infoAlert.getText());
    assertEquals(infoAlert.getText(),"I am a JS Alert");
    infoAlert.accept();

    //assert confirmation page is displayed
    WebElement resultMSg = driver.findElement(By.xpath("//p[.='You successfuly clicked an alert']"));
    System.out.println("resultMSg = " + resultMSg.getText());
    assertEquals(resultMSg.getText(), "You successfuly clicked an alert");




}
@Test
    public void confirmAlertTest(){
    /**
    click on JS Confirm link
    switch to alert then assert the text is "I am a JS Confirm"
     click on cancel
     assert result message is "You clicked: Cancel"'
     */
    driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();

    Alert alert2 = driver.switchTo().alert();
    System.out.println("Text of JS Confirm Alert" + alert2.getText());
    assertEquals(alert2.getText(),"I am a JS Confirm" );
    alert2.dismiss();
    WebElement alert2Msg = driver.findElement(By.xpath("//p[@id='result']"));
    System.out.println("The JS confirm text = " + alert2Msg.getText());
    assertEquals(alert2Msg.getText(), "You clicked: Cancel");
}
@Test
    public void PromptAlertTest() throws InterruptedException {
    /**
     //click on JS prompt button
     //switch to alert and assert/confirm the text is "I am a JS prompt"
     //enter "hello" and click on Ok
     //assert "You entered: hello" message is displayed
     */

    driver.findElement(By.xpath("//button[contains(text() , 'Prompt')]")).click();

    Alert alert3 = driver.switchTo().alert();
    System.out.println("text of JS prompt alert: " + alert3.getText());

    alert3.sendKeys("hello, hello");

    alert3.accept();

    WebElement alert3Msg = driver.findElement(By.id("result"));
    System.out.println("JS prompt msg = " + alert3Msg.getText());
    assertEquals(alert3Msg.getText(),"You entered: hello, hello" );

}

}















