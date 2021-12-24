package com.cybertek.pages.Edmundpages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Set;

public class EdmundsNewCarPage extends BasePage{

    @FindBy(name = "select-make")
    public WebElement make;

    @FindBy(name = "select-model")
    public WebElement model;

    @FindBy(xpath = "//input[@name='make_model_tab']")
    public WebElement zipcode;

    @FindBy(xpath = "//button[@data-tracking-id='new_cars_index_mmy_make_model_tab_submit']")
   public WebElement goBtn;

    public void selectMake(String carMake){
        Select makeDropDown = new Select(make);
        makeDropDown.selectByVisibleText(carMake);
    }
    public void selectModel(String carModel){
        Select madelDropDown = new Select(model);
        madelDropDown.selectByVisibleText(carModel);
    }
    public void enterZipClickGo(String zipCode){
        zipcode.clear();
        zipcode.sendKeys(zipCode + Keys.ENTER);

    }




    @Override
    public void isCurrentPage() {
      Assert.assertEquals(driver.getTitle(),"New Cars for Sale - Pricing and Deals | Edmunds");

    }


}
