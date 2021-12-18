package com.cybertek.tests.day14_webtables_properties;

import com.cybertek.utils.SmartBearUtils;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.util.*;

public class SmartBear extends SmartBearTestBase {


    @Test
    public void TC1_LinkVerification(){

    SmartBearUtils.loginToSmartBear(driver);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("links.size() = " + links.size());
        for (WebElement link : links) {
            System.out.println("links text is "+ link.getText());
        }
    }
    @Test
    public void TC2_OrderPlacing(){

        SmartBearUtils.loginToSmartBear(driver);
        SmartBearUtils.AddProduct(driver);
        WebElement name= driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName"));





    }
}
