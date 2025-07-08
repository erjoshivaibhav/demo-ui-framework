package com.ui.utilities;

import com.ui.constants.BrowserName;
import static com.ui.constants.Environments.*;
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

    public BrowserUtility(BrowserName browser)  {
        // if condition for type of brewser and initializing the driver
        if (browser.name().equalsIgnoreCase("chrome")) {
            this.driver = new ChromeDriver();
        } else if (browser.name().equalsIgnoreCase("firefox")) {
            this.driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser,try with chrome or firefox ");
        }
        driver.manage().window().maximize();
//        driver.get(PropertiesUtility.getProperty("URL"));
        driver.get(JsonUtility.readJson(QA));
    }

    //method to get driver
    public WebDriver getDriver() {
        return this.driver;
    }

    // Method to open a URL
    public void openUrl(String url) {
        if (driver != null) {
            driver.get(url);
            driver.manage().window().maximize();
        } else {
            throw new IllegalStateException("WebDriver is not initialized.");
        }
    }

    //method to click by taking by locator as parameter
    public void clickElement(By locator) {
        if (driver != null) {
            driver.findElement(locator).click();
        } else {
            throw new IllegalStateException("WebDriver is not initialized.");
        }
    }

    // Method to enter text into an input field
    public void enterText(By locator, String text) {
        if (driver != null) {
            driver.findElement(locator).sendKeys(text);
        } else {
            throw new IllegalStateException("WebDriver is not initialized.");
        }
    }
}
