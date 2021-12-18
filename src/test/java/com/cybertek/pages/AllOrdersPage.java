package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllOrdersPage extends SmartBearDashboardPage{
// Do I have to put constructor? NO
    //Const is not inherited, however vhild class has to call Parent class constructor

    @FindBy(id="ctl00_MainContent_btnDelete")
    public WebElement deleteSelected;

//I want to go to other links in the AllOrder PAge, do I have to create
//create a method that selects the checkbox with using name of the Person

    // "//td[.='Mark Smith']/..//input[@type='checkbox']"
    //String name = "Mark Smith"
    //"//td[.='"+ name +"']/..//input[@type='checkbox']"
    public void selectCheckBox(String name){
        Driver.getDriver().findElement(By.xpath("//td[.='"+ name +"']/..//input[@type='checkbox']")).click();
    }
}
