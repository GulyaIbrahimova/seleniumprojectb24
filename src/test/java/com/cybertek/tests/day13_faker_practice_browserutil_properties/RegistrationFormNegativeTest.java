package com.cybertek.tests.day13_faker_practice_browserutil_properties;

import com.cybertek.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class RegistrationFormNegativeTest extends RegistrationFormTestBase{

    @Test
    public void invalidFirstNameTest(){
        //do not enter any value and click on sign up
        //first name is required" error msg should be displayed
        driver.findElement(By.id("wooden_spoon")).click();

        //wait for 1 second

        BrowserUtils.sleep(2);
        WebElement errorMsg = driver.findElement(By.xpath("//small[.='first name is required']"));

        //type 1234 and verify "first name can only consist of alphabetical letters"
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("12345");
        WebElement noNumbersMsg = driver.findElement(By.xpath("//small[.='first name can only consist of alphabetical letters']"));
        Assert.assertEquals(noNumbersMsg.getText(),"first name can only consist of alphabetical letters");




        }
}
