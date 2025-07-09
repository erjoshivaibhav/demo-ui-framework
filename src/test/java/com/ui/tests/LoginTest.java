package com.ui.tests;

import com.pojos.User;
import com.ui.pages.HomePage;
import com.ui.utilities.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.ui.constants.BrowserName.CHROME;
import static org.testng.Assert.assertEquals;
@Listeners({com.ui.listeners.MyTestListener.class})
public class LoginTest {
    private HomePage homePage;
    Logger log = LoggerUtility.getLogger(this.getClass());


    @BeforeMethod(description = "Initialize HomePage before each test method")
    public void setUp() {
        homePage = new HomePage(CHROME);
    }

    @AfterMethod(description = "Exit HomePage after each test method")
    public void tearDown() {
        homePage.exit();
    }


    @Test(description = "Verify successful login with valid credentials", dataProviderClass = com.dataProviders.LoginTestDataProvider.class, dataProvider = "loginDataProviderJSON")
    public void positiveLoginTestJSON(User user) {
        assertEquals(homePage.navigateToSignInPage()
                        .login(user.getEmail(), user.getPassword())
                        .getAccountName(),
                "Deadpool Avenger", "Account name does not match expected value.");

    }

    @Test(description = "Verify successful login with valid credentials", dataProviderClass = com.dataProviders.LoginTestDataProvider.class, dataProvider = "loginDataProviderCSV")
    public void positiveLoginTestCSV(User user) {
        assertEquals(homePage.navigateToSignInPage()
                        .login(user.getEmail(), user.getPassword())
                        .getAccountName(),
                "Deadpool Avenger", "Account name does not match expected value.");

    }

    @Test(description = "Verify successful login with valid credentials", dataProviderClass = com.dataProviders.LoginTestDataProvider.class, dataProvider = "loginDataProviderEXCEL",
            retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    public void positiveLoginTestEXCEL(User user) {
        assertEquals(homePage.navigateToSignInPage()
                        .login(user.getEmail(), user.getPassword())
                        .getAccountName(),
                "Deadpool Avenger", "Account name does not match expected value.");

    }
}
