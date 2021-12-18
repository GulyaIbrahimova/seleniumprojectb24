package com.cybertek.tests.day15_properties_diverutil_testbase;

import org.testng.annotations.Test;

public class SystemPropertiesTest {

    @Test
    public void readingSystemProperties(){
        System.out.println("OS name " + System.getProperty("os.name"));//System is  a class in Java
        //os.name-> operating system -> Windows 10
        System.out.println("User name "+ System.getProperty("user.name"));
        System.out.println("User directory " + System.getProperty("user.dir"));
        System.out.println("Pom.xml path "+ System.getProperty("user.dir") + ("/pom.xml"));
        System.out.println("java version " + System.getProperty("java.version"));


    }
}
