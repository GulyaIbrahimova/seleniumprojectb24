package com.cybertek.tests.practice;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class IQ3 {

    //Arraylist method will remove empty elements from list

   public void emptyList(ArrayList<String> list){
       list.removeIf(String::isEmpty);
    }
}
