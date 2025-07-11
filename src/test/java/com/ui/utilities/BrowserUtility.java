package com.ui.utilities;

import com.ui.constants.BrowserName;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.ui.constants.Environments.QA;

public abstract class BrowserUtility {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    Logger log = LoggerUtility.getLogger(this.getClass());

    public BrowserUtility(WebDriver customDriver) {
        driver.set(customDriver);
    }

    public BrowserUtility(BrowserName browser) {
        log.info("Initializing WebDriver for browser: " + browser.name());
        // if condition for type of brewser and initializing the driver
        if (browser.name().equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        } else if (browser.name().equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver());
        }
        else if (browser.name().equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());
        }
        else {
            throw new IllegalArgumentException("Unsupported browser,try with chrome or firefox ");
        }
        log.info("WebDriver initialized successfully for browser: " + browser.name());
        log.info("Maximizing browser window");
        driver.get().manage().window().maximize();
//        driver.get(PropertiesUtility.getProperty("URL"));
        log.info("Navigating to the URL: " + JsonUtility.readJson(QA).getUrl());
        driver.get().get(JsonUtility.readJson(QA).getUrl());
    }

    //method to get driver
    public WebDriver getDriver() {
        return this.driver.get();
    }

    // Method to open a URL
    public void openUrl(String url) {
        log.info("Navigating to URL: " + url);

        if (driver != null) {
            driver.get().get(url);
            driver.get().manage().window().maximize();
        } else {
            throw new IllegalStateException("WebDriver is not initialized.");
        }
    }

    //method to click by taking by locator as parameter
    public void clickElement(By locator) {
        log.info("Clicking on element with locator: " + locator);
        if (driver != null) {
            driver.get().findElement(locator).click();
        } else {
            throw new IllegalStateException("WebDriver is not initialized.");
        }
    }

    // Method to enter text into an input field
    public void enterText(By locator, String text) {
        log.info("Entering text: '" + text + "' into element with locator: " + locator);
        // Check if driver is initialized before interacting with elements
        if (driver.get() != null) {
            driver.get().findElement(locator).sendKeys(text);
        } else {
            throw new IllegalStateException("WebDriver is not initialized.");
        }
    }

    //method to take screenshot
    public String takeScreenshot(String fileName) {
        log.info("Taking screenshot and saving as: " + fileName);
        TakesScreenshot screenshotTaker = (TakesScreenshot) driver.get();
        String path;
        long timestamp = System.currentTimeMillis();
        try {
            // Capture the screenshot and store it in a file
            File screenshotFile = screenshotTaker.getScreenshotAs(OutputType.FILE);
            // Define the destination file path
            path = System.getProperty("user.dir") + "\\screenshots\\" + fileName +timestamp+".jpeg";
            File destinationFile = new File(path);
            // Copy the screenshot to the destination file
            FileUtils.copyFile(screenshotFile, destinationFile);
            log.info("Screenshot saved successfully at: " + destinationFile.getAbsolutePath());
        } catch (FileNotFoundException e) {
            log.error("Failed to save screenshot: " + e.getMessage());
            throw new RuntimeException("Failed to save screenshot", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }

}
