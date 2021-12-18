package com.cybertek.tests.day07_findelements;

public class SearchMinuteClinicLocationsTest {
    /**
        CVS Minute Clinic Search Task
    • Add new class SearchMinuteClinicLocationsTest
    • Goto https://www.cvs.com/
    • Click on “MinuteClinic” link
    • On Next page, Locate and check if minute clinic logo is displayed
    • Enter zipcode 22102 or any other then click on “Find a clinic” button
    • On Search results page using If else statements:
    o Locate and Verify “Clinic Locator” label is displayed
    o Locate and Verify Value in zip code box is same as you entered on previous
    page
    § getAttribute(“value”) can be used to read the value
    o Locate and Verify label results count label contains your zip code
    § getText and contains method can be used
    • Extract and print all addresses of the clinic locations. Please use <div class=”addressinformation”> with findElements method to get all addresses
    • Quit the browse */
    public static void main(String[] args) {

    }
}
