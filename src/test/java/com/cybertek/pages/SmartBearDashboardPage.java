package com.cybertek.pages;

import com.cybertek.tests.day14_webtables_properties.SmartBear;
import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class SmartBearDashboardPage {
    //constructor

    public SmartBearDashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void getLink(String link){
        Driver.getDriver().findElement(By.partialLinkText(link));

    }



}
