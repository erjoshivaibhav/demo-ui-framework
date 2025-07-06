package com.ui.pages;

import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BrowserUtility {
    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[@title='Log in to your customer account']");


    public HomePage(String browserName){
        super(browserName);

    }

    //nmavigate to sign in page
    public LoginPage navigateToSignInPage() {
        clickElement(SIGN_IN_LINK_LOCATOR);
        return new LoginPage(getDriver());
    }


}
