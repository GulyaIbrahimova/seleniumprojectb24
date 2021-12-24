package com.cybertek.pages.Edmundpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EdmundsCarDetailsPage extends BasePage{


    @FindBy(xpath = "//span[@class='d-inline-block']")
    public WebElement msrpRange;


    @Override
    public void isCurrentPage() {
        //"| Edmunds" this part is the same for all the page
        Assert.assertTrue(driver.getTitle().contains("| Edmunds"));

    }

    public String getMsrpRangeValue(){
        return msrpRange.getText();
    }
}
