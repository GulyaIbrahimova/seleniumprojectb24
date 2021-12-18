package com.cybertek.tests.day09_testng_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGIntro {

    //can be used by each test
    String url = "https://www.etsy.com";
    @BeforeClass
    public void setUp(){
        System.out.println("@BeforeClass setup method");
        System.out.println("Open browser and Navigating to " + url);
        System.out.println("===============================");
    }
    @BeforeMethod
    public void setUpApp(){
        System.out.println("@BeforeMethod setUpp method is running\n Navigating back to " + url+ "\n"+ "===============================");
    }

    @Test(priority = 1)
    public void test1(){
        System.out.println("Running my Test 1");
        int num = 10;
        Assert.assertEquals(10,num);

    }
    @Test(priority = 2)//converts regular method to test method
   public void myTest2(){//this will run 1st alphabetical order
        System.out.println("Running my Test 2");
        String name = "Bob";
        Assert.assertTrue(name.contains("o"));
   }
   @AfterMethod
    public void tearDown(){
       System.out.println("AfterMethod tearDown is running");
       System.out.println("================================");
   }
    @AfterClass
    public void cleanUp(){
        System.out.println("@AfterClass cleanUp method is running ...");
        System.out.println("======================================");
    }

}
