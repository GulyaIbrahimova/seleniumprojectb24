package com.cybertek.tests.day23_fluentwait_testng_overview;


import com.cybertek.pages.Edmundpages.BasePage;
import com.cybertek.pages.Edmundpages.EdmundsCarDetailsPage;
import com.cybertek.pages.Edmundpages.EdmundsHomePage;
import com.cybertek.pages.Edmundpages.EdmundsNewCarPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.testng.annotations.Test;

import java.util.HashMap;

public class EdmundNewCarSearchTest extends TestBase {

    @Test
    public void searchForNewCarTest() {
        driver.get(ConfigurationReader.getProperty("edmunds.url"));
        EdmundsHomePage homePage = new EdmundsHomePage();
        homePage.isCurrentPage();
        homePage.goToNewCarPricingPage();

        EdmundsNewCarPage newCarPage = new EdmundsNewCarPage();
        newCarPage.selectMake("Audi");

        newCarPage.selectModel("e-tron GT");

        //Enter zipcode and click on GO
        newCarPage.enterZipClickGo("92071");

        EdmundsCarDetailsPage carDetailsPage = new EdmundsCarDetailsPage();
        carDetailsPage.isCurrentPage();
        System.out.println("Price Range " + carDetailsPage.getMsrpRangeValue());



    }

}
