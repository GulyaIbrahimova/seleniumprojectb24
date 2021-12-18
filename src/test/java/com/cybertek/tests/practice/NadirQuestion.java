package com.cybertek.tests.practice;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NadirQuestion {

/**-put Vehicle, Vehicle Odometer, Vehicle Costs, Vehicle contracts,  Vehicle Fuel Logs, Vehicle Service Logs, Vechile Models in one list, and get those from html and store in another. then validate if your expected is matching with actual*/
        String url = "https://qa2.vytrack.com";
        WebDriver driver;
        String user = "salesmanager101";
        String pass = "UserUser123";

        @BeforeMethod
        public void setUp () throws InterruptedException {
            driver = WebDriverFactory.getDriver("chrome");
            driver.get(url);
            driver.findElement(By.id("prependedInput")).sendKeys(user);
            Thread.sleep(1000);
            driver.findElement(By.id("prependedInput2")).sendKeys(pass + Keys.ENTER);
        }

        @Test
        public void getVyTrackInfo () throws InterruptedException {

            WebElement fleetButton = driver.findElement(By.xpath("//span[contains(text(),' Fleet')][1]"));
            Thread.sleep(2000);
            fleetButton.click();

            List<WebElement> list = driver.findElements(By.xpath("//span[starts-with(text(), 'Vehicle')]"));

            Thread.sleep(2000);

            int count = 0;
            for (WebElement each : list) {
                System.out.println(each.getText());
                count++;
            }
            if (count == 7) {
                System.out.println("Pass: Truck driver can see all Vehicle info");
            } else {
                System.out.println("Fail: Truck driver cannot see all Vehicle info");
            }

        }

        @AfterMethod
        public void cleanUp () {
            System.out.println();
            System.out.println("Cleaning up the code))");
            driver.quit();
        }

        }
    /*

    public void exercise1() throws InterruptedException, IOException {
        driver.get("http://te.dev.secureci.com/Exercise1.html%22);
        List<WebElement> list = driver.findElements(By.tagName("area"));
        System.out.println(list.size());
        for (WebElement link : list) {
            String href = link.getAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) (new URL(href).openConnection());
            connection.setRequestMethod("HEAD");
            connection.connect();
            Assert.assertEquals(href + " not a valid link", 200, connection.getResponseCode());

        }
    }
    public static boolean comparetwoList(List<String> first, List<String> second){
 return second.stream().allMatch(t -> first.stream().anyMatch(t::contains));
}

     */



