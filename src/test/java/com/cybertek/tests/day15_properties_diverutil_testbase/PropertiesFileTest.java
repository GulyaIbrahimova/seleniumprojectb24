package com.cybertek.tests.day15_properties_diverutil_testbase;

import com.cybertek.utils.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesFileTest {
    @Test
    public void readValuesFromPropertiesFile() throws Exception {
        //properties class - comes from java library
        Properties props = new Properties();

        //open file using a class called FileInputStream -class in Java we use to read files
        //comes from java.io package io means input output
       FileInputStream fis = new FileInputStream("configuration.properties");

        //load file content into properties object
        props.load(fis);

        System.out.println(props.getProperty("browser"));
        System.out.println(props.getProperty("webtableUrl"));//case sensitive
        System.out.println(props.getProperty("env"));

    }
    @Test
    public void configurationReaderUnitTest(){
        System.out.println(ConfigurationReader.getProperty("browser"));
        String url = ConfigurationReader.getProperty("webtableUrl");
        System.out.println("url = " + url);
        Assert.assertEquals(ConfigurationReader.getProperty("browser"), "chrome");
        Assert.assertEquals(ConfigurationReader.getProperty("env"), "qa");
        Assert.assertEquals(ConfigurationReader.getProperty("hello"),null);
    }

    }

