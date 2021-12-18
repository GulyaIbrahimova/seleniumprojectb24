package com.cybertek.tests.day13_faker_practice_browserutil_properties;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class RegistrationFormTest extends RegistrationFormTestBase {
    Faker faker = new Faker();

@Test
    public void formTest() {

    WebElement firstName = driver.findElement(By.name("firstname"));
    firstName.sendKeys(faker.name().firstName());

    WebElement lastName = driver.findElement(By.name("lastname"));
    lastName.sendKeys(faker.name().lastName());

    enterUserName(faker.name().username().replace(".",""));


    WebElement email = driver.findElement(By.name("email"));
    email.sendKeys(faker.internet().emailAddress());

    WebElement password = driver.findElement(By.name("password"));
    password.sendKeys(faker.internet().password());

    WebElement mobile = driver.findElement(By.name("phone"));
    mobile.sendKeys(faker.phoneNumber().cellPhone().
            replace("(","").
            replace(")","").
            replace(".","-")
            .replace(" " , "-"));

    WebElement femaleRadio = driver.findElement(By.xpath("//*[@value='female']"));
    femaleRadio.click();
    WebElement birthDay= driver.findElement(By.name("birthday"));
    birthDay.sendKeys("04/16/1988");

    Select department =new Select(driver.findElement(By.name("department")));
    department.selectByIndex(faker.number().numberBetween(1,8));
    Select jobTitle = new Select(driver.findElement(By.name("job_title")));
    jobTitle.selectByIndex(faker.number().numberBetween(1,8));

   List<WebElement> languages = driver.findElements(By.className("form-check-input"));
    for (WebElement eachLanguage : languages) {
        eachLanguage.click();

    }
    driver.findElement(By.id("wooden_spoon")).click();
    WebElement heading = driver.findElement(By.className("alert-heading"));
    Assert.assertEquals(heading.getText(),"Well done!");
    Assert.assertTrue(heading.isDisplayed());

}
    public void enterUserName(String userName){
        WebElement userNameField = driver.findElement(By.name("username"));
        userNameField.sendKeys(userName);
    }


}



/**
 TC#6: Cybertek registration form confirmation
 Note: Use JavaFaker when possible.
 1. Open browser
 2. Go to website: http://practice.cybertekschool.com/registration_form
 3. Enter first name
 4. Enter last name
 5. Enter username
 6. Enter email address
 7. Enter password
 8. Enter phone number
 9. Select a gender from radio buttons
 10.Enter date of birth
 11.Select Department/Office
 12.Select Job Title
 13.Select programming language from checkboxes
 14.Click to sign up button
 15.Verify success message “You’ve successfully completed registration.” is
 displayed.
 */