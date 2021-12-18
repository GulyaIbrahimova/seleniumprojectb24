package com.cybertek.utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public class LinkCounter {
    public static void linkCounter(List<WebElement> links){
        int counter = 0;
        int emptyLinkCounter = 0;
        for (WebElement link : links) {
            if (!link.getText().isEmpty()){
                counter++;
            }else {
                emptyLinkCounter++;
            }
        }
        System.out.println("Total missing links for given page "+ emptyLinkCounter);
        System.out.println("Total links are displayed for given page: " + counter);
        System.out.println("======================================");
    }
}
