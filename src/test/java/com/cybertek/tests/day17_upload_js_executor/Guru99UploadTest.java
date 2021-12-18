package com.cybertek.tests.day17_upload_js_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Guru99UploadTest extends TestBase {
    @Test
    public void uploadFileTest(){
        driver.get(ConfigurationReader.getProperty("guru99upload.url"));
        //locate elements
        WebElement chooseFileElem =driver.findElement(By.id("uploadfile_0"));
        WebElement termsCheckbox= driver.findElement(By.id("terms"));
        WebElement submitFile =driver.findElement(By.id("submitbutton"));

        //set file path
        chooseFileElem.sendKeys(System.getProperty("user.home") + "/Downloads/some-file.txt");
        termsCheckbox.click();//check the term checkBox
        submitFile.click();//click on submit button
        //verify upload success by checking
        BrowserUtils.sleep(2);
        WebElement msg = driver.findElement(By.id("res"));
        System.out.println("msg = " + msg.getText());
        Assert.assertEquals(msg.getText(), "1 file\nhas been successfully uploaded.");



            }

}
