package com.cybertek.tests.day19_page_object_model;

import com.cybertek.pages.BookManagementPage;
import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LibraryLoginPOMTest extends TestBase {

    @Test
    public void invalidCredentialsTest(){
        driver.get(ConfigurationReader.getProperty("library3.url"));

        //Create obj.of LibraryLoginPage obj class
        LibraryLoginPage loginPage = new LibraryLoginPage();
        //access email WebElement
        loginPage.email.sendKeys("Invalid_email@gmail.com");
        loginPage.password.sendKeys("1234");
        loginPage.signInBtn.click();

        Assert.assertTrue(loginPage.errorMSg.isDisplayed());
        Assert.assertEquals(loginPage.errorMSg.getText(), "Sorry, Wrong Email or Password");


    }
    @Test
    public void invalidCredentialsTestWithFaker(){
        LibraryLoginPage loginPage=new LibraryLoginPage();
        driver.get(ConfigurationReader.getProperty("library3.url"));
        loginPage.email.sendKeys(faker.internet().emailAddress());
        loginPage.password.sendKeys(faker.internet().password());
        loginPage.signInBtn.click();
    }
    @Test
    public void validCredentialsTest(){
        LibraryLoginPage loginPage=new LibraryLoginPage();
        driver.get(ConfigurationReader.getProperty("library3.url"));
        loginPage.email.sendKeys(ConfigurationReader.getProperty("library3.student.email"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("library3.student.password"));
        loginPage.signInBtn.click();
        //Book management page steps: verify is correct page, verify is displayed

        BookManagementPage bookManagementPage =new BookManagementPage();
        Assert.assertTrue(bookManagementPage.bookManagementHeader.isDisplayed());
        bookManagementPage.isCurrentPage();



        }

}
