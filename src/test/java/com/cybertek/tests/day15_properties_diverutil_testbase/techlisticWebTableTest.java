package com.cybertek.tests.day15_properties_diverutil_testbase;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class techlisticWebTableTest extends TestBase {
    /**
     Goto    https://www.techlistic.com/p/demo-selenium-practice.html
     Assert current title contains "techlistic"
     Print all Building names

     */

    @Test
    public void tallBuildingTableTest(){
        driver.get(ConfigurationReader.getProperty("techListic.url"));

        Assert.assertTrue(driver.getCurrentUrl().contains("techlistic"));

        List<WebElement> buildingNames =driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr/th"));
        for (WebElement buildingName : buildingNames) {
            System.out.println("Building name is : "  + buildingName.getText());

        }
        System.out.println(  driver.findElement(By.xpath("//table[@class='tsc_table_s13']//td[contains(text(),'buildings')]")).getText());





    }



}
