package com.ui.pages;

import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BrowserUtility {

    // Locators for the My Account page elements can be defined here

     private static final By ACCOUNT_NAME_LOCATOR = By.xpath("//a[@title='View my customer account']");

    public MyAccountPage(WebDriver driver) {
        super(driver); // Assuming Chrome is the default browser
    }

    //method to fetch account name
     public String getAccountName() {
         return getDriver().findElement(ACCOUNT_NAME_LOCATOR).getText();
     }
}
