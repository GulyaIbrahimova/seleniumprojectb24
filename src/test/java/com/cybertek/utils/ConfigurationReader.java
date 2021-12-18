package com.cybertek.utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 this util class is used to read values from configuration.properties file
 date: 12/5/21
 */

public class ConfigurationReader {


    //private -> only visible in this class
    //static -> we will use static methods
    //static block:
    private static final Properties properties = new Properties();//static block can not use non static variables

    static {
       try{
           //Open the file using inputStream
           FileInputStream inputStream = new FileInputStream("configuration.properties");

           //load to properties object
           properties.load(inputStream);
           //close the file after loading
           inputStream.close();

       }catch (Exception e){
           e.printStackTrace();//print error
           System.out.println("Error occurred while reading configuration file");

       }
    }

    /**
     *
     * Method is used to read value from a configuration.properties value
     * @param key -> key names in properties file
     * @return ->  value for the key. returns null if key not found
     * EX: driver.get( ConfigurationReader.getProperty("url") ) ;
     */
    public static String getProperty(String key){
        return  properties.getProperty(key);

    }






}
