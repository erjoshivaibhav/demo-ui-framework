package com.ui.listeners;

import com.ui.constants.Environments;
import com.ui.utilities.JsonUtility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    // Uncomment the line below if you want to use PropertiesUtility instead of JsonUtility
    // private static final int MAX_RETRY_COUNT = Integer.parseInt(PropertiesUtility.getProperty(Environments.QA, "MAX_RETRY_COUNT"));

    // Using JsonUtility to read the maximum retry count from the configuration file
    private static final int MAX_RETRY_COUNT = Integer.parseInt(JsonUtility.readJson(Environments.QA).getMAX_RETRY_COUNT());
    private static int currentRetryCount = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (currentRetryCount <= MAX_RETRY_COUNT) {
            currentRetryCount++;
            return true;
        }
        return false;
    }
}
