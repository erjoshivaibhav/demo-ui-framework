package com.ui.pages;
import com.ui.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends BrowserUtility {

    // Locators for the login page elements
    private static final By EMAIL_INPUT_LOCATOR = By.id("email");
    private static final By PASSWORD_INPUT_LOCATOR = By.id("passwd");
    private static final By SIGN_IN_BUTTON_LOCATOR = By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {
        super(driver); // Assuming Chrome is the default browser
    }

    // Method to log in with email and password
    public MyAccountPage login(String email, String password) {
        enterText(EMAIL_INPUT_LOCATOR, email);
        enterText(PASSWORD_INPUT_LOCATOR, password);
        clickElement(SIGN_IN_BUTTON_LOCATOR);
        return new MyAccountPage(getDriver()); // Assuming MyAccountPage is the next page after login
    }
}
