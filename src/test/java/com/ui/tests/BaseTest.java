package com.ui.tests;

import com.ui.pages.HomePage;
import com.ui.utilities.BrowserUtility;
import com.ui.utilities.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.ui.constants.BrowserName.CHROME;
import static com.ui.constants.BrowserName.EDGE;

public class BaseTest {

    protected HomePage homePage;
    Logger log = LoggerUtility.getLogger(this.getClass());


    @BeforeMethod(description = "Initialize HomePage before each test method")
    public void setUp() {
        homePage = new HomePage(EDGE);
    }

    @AfterMethod(description = "Exit HomePage after each test method")
    public void tearDown() {
        homePage.exit();
    }

    public BrowserUtility getInstance() {
        log.info("Instance of HomePage created successfully.");
        return homePage;
    }

}
