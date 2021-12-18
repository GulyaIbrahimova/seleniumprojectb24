package com.cybertek.tests.day16_download_uploaded_js_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FileDownloadTest extends TestBase {
/**
 add app url to configuration.properties :
 download.url = http://practice.cybertekschool.com/download

 - add @Test fileDownloadTest and navigate to the download.url
 - read value using ConfigurationReader utility class
 */
@Test
    public void fileDownloadTest() throws IOException {

    //Navigate to diwnload page . reading url from properties file
   // Driver.getDriver().get(ConfigurationReader.getProperty("download.url"));
    driver.get(ConfigurationReader.getProperty("download.url"));
    WebElement someFileDownload = driver.findElement(By.linkText("some-file.txt"));
    someFileDownload.click();

    BrowserUtils.sleep(2);
    //verify that file is downloaded: C:\Users\18582\Downloads
    String filePath = System.getProperty("user.home") + "/Downloads/some-file.txt";
    System.out.println("filePath = " + filePath);
    File file = new File(filePath);
    System.out.println("file exists " + file.exists());
//    while (file.exists()){
//        BrowserUtils.sleep(3);
//    }
    Assert.assertTrue(file.exists(),"File does not exists");
    //delete after verification complete
    file.delete();
    file.createNewFile();



}


}
