package com.cybertek.office_hour;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PriceTestTwo {
    /**Test Case 1:
     Total Order Price Calculation 1
     - Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
     - Login with username: Tester, password: test
     - Click  Order button
     - Verify under Product Information, selected option is “MyMoney”
     -Then select FamilyAlbum, make quantity 2, and click Calculate,
     - Then verify Total is equal to Quantity*PricePerUnit */

    static WebDriver driver;//we made webdriver static
    String url = "https://www.demoblaze.com/index.html#";
    int expTotalPrice = 0;//there is no item in my cart, exp.item =0;

    @BeforeClass
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    // useful method to use
    public static void getLink(String str){                  // we can not call instance variable from static
        driver.findElement(By.partialLinkText(str)).click(); // we made the webdriver static
    }
  /*  public static int addProduct(String category, String product){
return ;
    }

   */

    @Test
    public void TestTwo() throws InterruptedException {
        //From Categories select Laptops, and from products select Sony Vaio i7
        getLink("Home");
        getLink("Laptops");
        getLink("Sony vaio i7");
        Thread.sleep(2000);

        WebElement priceContainer = driver.findElement(By.xpath("//h3"));

        //I need a var. that will hold all the prices that I am adding
        int price = Integer.parseInt(priceContainer.getText().substring(1,4));
        System.out.println("expected Total price= " + expTotalPrice);
        getLink("Add to cart");
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();






    }
}
