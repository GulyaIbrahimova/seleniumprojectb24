package com.cybertek.pages.Edmundpages;


import org.testng.Assert;

public class EdmundsHomePage extends BasePage{

    /**
     Automatically called by compiler
     no-args default constructor
     super() call to parent class no-args constructor
     public EdmundsHomePage() {
     super();
     }


     */

    @Override
    public void isCurrentPage() {
       Assert.assertEquals(driver.getTitle(),"New Cars, Used Cars, Car Reviews and Pricing | Edmunds");

    }
}
