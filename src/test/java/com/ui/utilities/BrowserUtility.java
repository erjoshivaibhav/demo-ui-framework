package com.ui.utilities;

import com.ui.constants.BrowserName;
import static com.ui.constants.Environments.*;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;

public abstract class BrowserUtility {

    private WebDriver driver;

    public BrowserUtility(WebDriver driver) {
        this.driver = driver;
    }
    Logger log = LoggerUtility.getLogger(this.getClass());

    public BrowserUtility(BrowserName browser)  {
        log.info("Initializing WebDriver for browser: " + browser.name());
        // if condition for type of brewser and initializing the driver
        if (browser.name().equalsIgnoreCase("chrome")) {
            this.driver = new ChromeDriver();
        } else if (browser.name().equalsIgnoreCase("firefox")) {
            this.driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser,try with chrome or firefox ");
        }
        log.info("WebDriver initialized successfully for browser: " + browser.name());
        log.info("Maximizing browser window");
        driver.manage().window().maximize();
//        driver.get(PropertiesUtility.getProperty("URL"));
        log.info("Navigating to the URL: " + JsonUtility.readJson(QA).getUrl());
        driver.get(JsonUtility.readJson(QA).getUrl());
    }

    //method to get driver
    public WebDriver getDriver() {
        return this.driver;
    }

    // Method to open a URL
    public void openUrl(String url) {
        log.info("Navigating to URL: " + url);

        if (driver != null) {
            driver.get(url);
            driver.manage().window().maximize();
        } else {
            throw new IllegalStateException("WebDriver is not initialized.");
        }
    }

    //method to click by taking by locator as parameter
    public void clickElement(By locator) {
        log.info("Clicking on element with locator: " + locator);
        if (driver != null) {
            driver.findElement(locator).click();
        } else {
            throw new IllegalStateException("WebDriver is not initialized.");
        }
    }

    // Method to enter text into an input field
    public void enterText(By locator, String text) {
        log.info("Entering text: '" + text + "' into element with locator: " + locator);
         // Check if driver is initialized before interacting with elements
        if (driver != null) {
            driver.findElement(locator).sendKeys(text);
        } else {
            throw new IllegalStateException("WebDriver is not initialized.");
        }
    }
}
