package com.cybertek.pages.Edmundpages;
import com.cybertek.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 This class is parent for all page object classes
 */
public abstract class BasePage {
    //WebDriver var just in case any of children need
    protected WebDriver driver;

    public BasePage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);

        //isCurrentPage();
    }

    @FindBy(xpath = "img[@alt = 'Home']")
    public WebElement edmundsLogo;

    @FindBy(linkText = "New Car Pricing")
    public WebElement newCarPricingLink;


    public void goToNewCarPricingPage(){
        //will click on the link
        newCarPricingLink.click();
    }

    /**
     abstract method to be implemented by child Page Object classes
     this is to verify that we are at current page
     using little of the page or anything other
     */
    public abstract void isCurrentPage();

}
