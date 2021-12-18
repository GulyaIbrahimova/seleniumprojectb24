package com.cybertek.tests.day16_download_uploaded_js_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {
    @Test
    public void uploadFileTest(){
        //driver.get(ConfigurationReader.getProperty("upload.url"));
        Driver.getDriver().get(ConfigurationReader.getProperty("upload.url"));
        WebElement upload = driver.findElement(By.id("file-upload"));

        upload.sendKeys(System.getProperty("user.home") + "/Downloads/some-file.txt");
        WebElement uploadButton =driver.findElement(By.id("file-submit"));
        uploadButton.click();
        /**
         verify file is uploaded
         check file name is displayed in home page
         */
        WebElement fileName =driver.findElement(By.id("uploaded-files"));
        String expFile ="some-file.txt";
        Assert.assertEquals(fileName.getText(),expFile,"file is not uploaded");


    }
}
