package com.cybertek.tests.day19_page_object_model;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import com.cybertek.utils.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest extends TestBase {
    @Test
    public void dragAndDropCircleTC16(){

        driver.get(ConfigurationReader.getProperty("hover_test.url"));
        WebElement target = driver.findElement(By.id("droptarget"));
        WebElement draggable = driver.findElement(By.id("draggable"));
        actions.dragAndDrop(draggable,target).perform();
        Assert.assertTrue(target.getText().contains("You did great"));

        /**
         TC	#16:	Hover	Test
         1. Go	to	https://demos.telerik.com/kendo-ui/dragdrop/index
         2. Drag	and	drop	the	small	circle	to	bigger	circle.
         3. Assert:
         -Text	in	big	circle	changed to:	“You	did	great!”
         */
    }
    @Test
    public void contextClickTC17(){
        driver.get(ConfigurationReader.getProperty("context_click.url"));
        WebElement box = driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        /**
         TC	#17:	Context	Click	– HOMEWORK
         1. Go	to	https://the-internet.herokuapp.com/context_menu
         2. Right	click	to	the	box.
         3. Alert	will	open.
         4. Accept	alert
         No	assertion	needed	for	this	practice
         */


    }


}
