package com.cybertek.tests.day14_webtables_properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.cybertek.utils.WebDriverFactory.getDriver;
import static org.testng.Assert.*;

public class WebTableDemoTest {

    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }
    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
    @Test
    public void readFromTableTest(){
        //Print table data as a single String, not so common
        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println("table1 text = " + table1.getText());

        //verify email is anywhere in the table
        assertTrue(table1.getText().contains("tconway@earthlink.net"));

        //print all column names in single line
        WebElement columns = driver.findElement(By.xpath("//table/thead/tr"));
        System.out.println("column names = " + columns.getText());

        //could do with tagName as wellSystem.out.println( table1.findElement(By.tagName("tr")).getText() );

        //print each column name in separate lines using a loop,

        List<WebElement> columnNames = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        System.out.println("columnNames counts = " + columnNames.size());
        int num = 1;
        for (WebElement eachColumnName : columnNames) {
            System.out.println("Column"+ num++ +" Name = " + eachColumnName.getText());

        }

       // System.out.println("First row in the first column= " + driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[1]")).getText());
        //instead created method

        System.out.println("row 1, col 4 " + getCellData(1,4));
        System.out.println("row 3, col 3 " + getCellData(3,3));

    }
    @Test
    public void getAllColumnData(){

        //print all names
        //print all emails
        WebElement name =driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
        System.out.println("2nd name in a row = " + name.getText());
        List<WebElement> names = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
        List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
        for (int i = 0; i < names.size(); i++) {
            System.out.println(i+1 +"- " + names.get(i).getText()+" "+ emails.get(i).getText());
        }
            //could do it separately as well
        for (int i = 0; i < emails.size(); i++) {
            System.out.println(i+1 +"- " + emails.get(i).getText());

        }
        System.out.println("----ALL EMAILS---");
        for (WebElement eachEmail : emails) {
            System.out.println(eachEmail.getText());
        }
    }





    @Test
    public void printAllTableDataTest(){
        //get rows counts and assign print rows counts variables and print it
        //go to table1, go to tbody, go to all rows/ tr-> //table[@id='table1']/tbody/tr
        int rowsCount=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        System.out.println("rows count=  " + rowsCount);
        for (int r = 1; r < rowsCount; r++) {
            for (int c = 1; c <=6; c++) {

//                String value = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+ r +"]/td["+c+"]")).getText();
//                System.out.println(value);

                //with calling a method
                System.out.println(getCellData(r,c));
            }

                   }
       // System.out.println("column count=  " + driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size());
        /**
         Table date => 2 d array => String[][] data
         table data => list of maps => List<map<String, String> data
         table data => list of costumer objects
         */

    }
    @Test
    public void readNeighborCell(){
        WebElement johnEmail = driver.findElement(By.xpath("//table[@id='table1']//td[.='John']/following-sibling::td[1]"));
        System.out.println("John's email " + johnEmail.getText());

        WebElement johnsLastName = driver.findElement(By.xpath("//table[@id='table1']//td[.='John']/preceding-sibling::td[1]"));
        System.out.println("Johns last name " + johnsLastName.getText());

    }
    public String getCellData(int row, int column){
        String xpathStr ="//table[@id='table1']/tbody/tr["+ row +"]/td["+column+"]" ;
        return driver.findElement(By.xpath(xpathStr)).getText();
    }

}
