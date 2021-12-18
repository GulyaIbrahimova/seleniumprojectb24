package com.cybertek.test_cases.library_task;

import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoginFunctionality extends TestBase {
    @Test
    public void loginFunctionality(){
        driver.get(ConfigurationReader.getProperty("library2.url"));

        Assert.assertEquals(driver.getTitle(), "Login - Library");

        LibraryLoginPage login = new LibraryLoginPage();
        login.email.sendKeys("librarian13@library");
        login.password.sendKeys("Sdet2022*");
        login.signInBtn.click();
        BrowserUtils.sleep(2);
        Assert.assertEquals(driver.getTitle(), "Library");
       List<WebElement> modules= driver.findElements(By.xpath("//span[@class='title']"));
//        System.out.println("modules size " + modules.size());

        Assert.assertEquals(modules.size(),3);

        int num=0;
        for (WebElement module : modules) {
            System.out.println("module "+num++ +"= "+ module.getText());

        }






    }
}
