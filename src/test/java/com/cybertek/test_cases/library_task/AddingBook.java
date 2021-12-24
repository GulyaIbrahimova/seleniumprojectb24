package com.cybertek.test_cases.library_task;

import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddingBook extends TestBase {

    @Test
    public void addBook() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("library2.url"));
        LibraryLoginPage loginPage = new LibraryLoginPage();
        loginPage.email.sendKeys("librarian46@library");
        loginPage.password.sendKeys("Sdet2022*");
        loginPage.signInBtn.click();

        BrowserUtils.sleep(2);
        driver.findElement(By.xpath("(//span[@class='title'])[3]")).click();

        BrowserUtils.sleep(2);
        driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sm add_book_btn']")).click();

        BrowserUtils.sleep(2);
        WebElement bookName = driver.findElement(By.xpath("//input[@placeholder='Book Name']"));
        bookName.sendKeys(faker.book().title());

        WebElement ISNB = driver.findElement(By.xpath("//input[@placeholder='ISBN']"));
        ISNB.sendKeys(faker.finance().iban());

        WebElement year = driver.findElement(By.xpath("//input[@placeholder='Year']"));
        year.sendKeys(faker.date().birthday().toString().substring(24));

        WebElement author = driver.findElement(By.xpath("//input[@placeholder='Author']"));
        author.sendKeys("group One Test");

        WebElement description = driver.findElement(By.xpath("//textarea[@id='description']"));
        description.sendKeys(faker.lorem().paragraph());


        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Thread.sleep(2000);
        List<WebElement> list = driver.findElements(By.xpath("//tr/td"));

        WebElement confMsg = driver.findElement(By.xpath("//div[@class='toast-message']"));
        Assert.assertTrue(confMsg.getText().contains("The book has been created."));




    }

}
