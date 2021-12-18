package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**I created my first page object 12/12/21 */
public class LibraryLoginPage {

    public LibraryLoginPage(){

        //Selenium command to initialize elements below
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "inputEmail")
   public WebElement email;//WebElement

    @FindBy(id="inputPassword")
   public WebElement password;

    @FindBy(xpath = "//button[.='Sign in']")
   public  WebElement signInBtn;

    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement errorMSg;







}
