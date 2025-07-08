package com.ui.tests;

import com.pojos.User;
import com.ui.pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.ui.constants.BrowserName.CHROME;
import static org.testng.Assert.assertEquals;

public class LoginTest {
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
            homePage = new HomePage(CHROME);
    }

    @AfterMethod
    public void tearDown() {
        homePage.exit();
    }


    @Test(description = "Verify successful login with valid credentials",dataProviderClass = com.dataProviders.LoginTestDataProvider.class, dataProvider = "loginDataProviderJSON")
    public void positiveLoginTestJSON(User user) {
        assertEquals(homePage.navigateToSignInPage()
                .login(user.getEmail(), user.getPassword())
                .getAccountName(),
                "Deadpool Avenger", "Account name does not match expected value.");

    }

    @Test(description = "Verify successful login with valid credentials",dataProviderClass = com.dataProviders.LoginTestDataProvider.class, dataProvider = "loginDataProviderCSV")
    public void positiveLoginTestCSV(User user) {
        assertEquals(homePage.navigateToSignInPage()
                        .login(user.getEmail(), user.getPassword())
                        .getAccountName(),
                "Deadpool Avenger", "Account name does not match expected value.");

    }

    @Test(description = "Verify successful login with valid credentials",dataProviderClass = com.dataProviders.LoginTestDataProvider.class, dataProvider = "loginDataProviderEXCEL")
    public void positiveLoginTestEXCEL(User user) {
        assertEquals(homePage.navigateToSignInPage()
                        .login(user.getEmail(), user.getPassword())
                        .getAccountName(),
                "Deadpool Avenger", "Account name does not match expected value.");

    }
}
