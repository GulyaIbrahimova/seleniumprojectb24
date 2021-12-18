package com.cybertek.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class BrowserUtils {
    /**
     *this method is used to pause the code for given seconds.
     * it is static method so we can call
     * BrowserUtils.sleep(5);
     * @param seconds
     */
    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("Exception happened in sleep method");
        }

    }


    /**
     *     Note: OOverloaded the method to scroll down until the given element is found.
     * @param pixels
     * scroll down by pixel
     */
    public static void scrollDown(int pixels){

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("window.scrollBy(0," + pixels + ")");

    }
    /**
     * @param elem
     * scroll down by given element
     */
    public static void scrollDown (WebElement elem) {
        //Casting the webDiver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //Scroll down until the given element found
        js.executeScript("arguments[0].scrollIntoView(true)", elem);

    }


}
