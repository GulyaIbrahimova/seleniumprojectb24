package com.cybertek.test_cases.vy_track_login_functionality;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class VyTrack {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://app.vytrack.com/user/login";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // wait up to 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        Thread.sleep(5000);

        WebElement userNameBox = driver.findElement(By.id("prependedInput"));
        userNameBox.sendKeys("user3");
        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys("UserUser123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='_submit']"));
        loginButton.click();
//<span class="title title-level-1"><i class="fa-asterisk menu-icon"></i>
//    Fleet</span>
        Thread.sleep(5000);
        WebElement fleetButton = driver.findElement(By.xpath("//span[contains(text(),'Fleet')][1]"));

        Thread.sleep(4000);


        fleetButton.click();
        Thread.sleep(5000);
//<span class="title title-level-2">Vehicles</span>
        WebElement vehicleButton = driver.findElement(By.xpath("//span[.='Vehicles']"));
        vehicleButton.click();
        //    System.out.println(driver.getTitle());
        Thread.sleep(5000);
//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Car - Entities - System - Car - Entities - System";
//        if (actualTitle.equals(expectedTitle)){
//            System.out.println("PASS: we can see all vehicle information");
//        }else {
//            System.out.println("FAIL: we can not see all vehicle information");
        // task2
        WebElement randomCar = driver.findElement(By.xpath("//td[.='wew1231']"));
        randomCar.click();
        //  System.out.println(driver.getTitle());

        Thread.sleep(5000);
        //task3
        //<a href="javascript: void(0);" class="btn icons-holder-text no-hash" title="Add an event to this record" data-id="19" data-url="/calendar/event/create?entityClass=Extend_Entity_Carreservation&amp;entityId=19&amp;_action=activity" data-bound-component="oroui/js/app/components/widget-component"><i class="fa-clock-o hide-text">Add Event</i>Add Event</a>

        WebElement addEvent = driver.findElement(By.xpath("//a[@title='Add an event to this record']"));
        addEvent.click();
        Thread.sleep(5000);

        WebElement testTextBox = driver.findElement(By.xpath("//input[@data-name='field__title']"));
        testTextBox.sendKeys("test" );
        Thread.sleep(5000);
//WebElement saveButton =
        driver.findElement(By.xpath("//button[.='Save']")).click();
    }
}
