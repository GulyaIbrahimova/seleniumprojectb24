package com.cybertek.test_cases.vy_track_login_functionality.assignment6;

import com.cybertek.test_cases.vy_track_login_functionality.LoginToVyTrack;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class VyTrackUS extends TestBase {


    /**User should be able to click Export Grid dropdown
     Verify user on Vytrack => Fleet => Vehicles, I should be able to see Export Grid dropdown
     */
    @Test
    public void verifyExportGridDropDownClickable(){


        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrack.url"));
        LoginToVyTrack.loginVyTrack(driver);
        WebElement vehicles=driver.findElement(By.xpath("//span[.='Vehicles']"));

       JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", vehicles );
        WebElement exportGrid = driver.findElement(By.xpath("//div[@class='btn-group']"));

        BrowserUtils.sleep(2);

        js.executeScript("arguments[0].click()", exportGrid);
        Assert.assertTrue(exportGrid.isEnabled());

    }

}
