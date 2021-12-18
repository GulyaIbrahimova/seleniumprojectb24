package com.cybertek.tests.day07_findelements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GasMileageCalculatorTask {
    /*
        Gas Mileage Calculator Automation Test - Add a new class GasMileageCalculatorTest
    - Goto https://www.calculator.net
    - Search for “gas mileage” using search box
    - Click on the “Gas Mileage Calculator” link
    - On Next page verify:
    o Title equals: “Gas Mileage Calculator”
    o “Gas Mileage Calculator” label is displayed
    - Locate, clear and type “7925” into “Current odometer” field
    - Locate, clear and type “7550” into “Previous odometer” field
    - Locate, clear and type “16” into “Gas added” field
    - Locate, clear and type “3.55” into “Gas price” field and Click on Calculate button
    - Locate and print the mpg value  */

    public static void main(String[] args) {

        /** - Goto https://www.calculator.net */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        String url = "https://www.calculator.net";
        driver.get(url);

        /** - Search for “gas mileage” using search box*/

        WebElement searchBox = driver.findElement(By.xpath("//input [@name='calcSearchTerm']"));
        searchBox.sendKeys("gas mileage");

        /** - Click on the “Gas Mileage Calculator” link */
        WebElement gasMileageCalculator = driver.findElement(By.linkText("Gas Mileage Calculator"));
        gasMileageCalculator.click();

        /** - On Next page verify: Title equals: “Gas Mileage Calculator” */
        String expectedTitle = "Gas Mileage Calculator";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title equals: “Gas Mileage Calculator”\n“Gas Mileage Calculator” label is displayed");
        }else {
            System.out.println("Fails: Title verification mismatch");
        }
        /**  Locate, clear and type “7925” into “Current odometer” field*/

        WebElement currentOdometerField = driver.findElement(By.cssSelector("input[id='uscodreading']"));
        currentOdometerField.clear();
        currentOdometerField.sendKeys("7925");
        /**
         Locate, clear and type “7550” into “Previous odometer” field*/
        WebElement previousOdometerField = driver.findElement(By.cssSelector("input[id = 'uspodreading']"));
        previousOdometerField.clear();
        previousOdometerField.sendKeys("7550");

        /** Locate, clear and type “16” into “Gas added” field  */
        WebElement gasAddedField = driver.findElement(By.cssSelector("input[id='usgasputin']"));
        gasAddedField.clear();
        gasAddedField.sendKeys("16");

        /**- Locate, clear and type “3.55” into “Gas price” field and Click on Calculate button*/
        WebElement gasPriceField =driver.findElement(By.cssSelector("input[id='usgasprice']"));
        gasPriceField.clear();
        gasPriceField.sendKeys("3.55");

        WebElement calculateButton = driver.findElement(By.cssSelector("input[value='Calculate']"));
        calculateButton.click();

        /** Locate and print the mpg value*/
        WebElement mpgValue = driver.findElement(By.tagName("b"));
        System.out.println("mpgValue = " + mpgValue.getText());







    }
}
