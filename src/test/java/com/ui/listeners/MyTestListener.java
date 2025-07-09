package com.ui.listeners;

import com.ui.utilities.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ui.utilities.LoggerUtility;
public class MyTestListener implements ITestListener {
    private Logger log = LoggerUtility.getLogger(this.getClass());
    public void onTestStart(ITestResult result) {
        log.info("Method : "+result.getMethod().getMethodName() + " started...");
        log.info("Method Description : "+result.getMethod().getDescription());

    }

    public void onTestSuccess(ITestResult result) {
        log.info("Method : "+result.getMethod().getMethodName() + " PASSED");

    }

    public void onTestFailure(ITestResult result) {
        log.error("Method : "+result.getMethod().getMethodName() + " FAILED");
        log.error("Failure description : "+result.getThrowable());

    }

    public void onTestSkipped(ITestResult result) {
        log.warn("Method : "+result.getMethod().getMethodName() + " SKIPPED");

    }
    public void onStart(ITestContext context) {
        log.info("Test Suite : " + context.getName() + " started...");
    }

    public void onFinish(ITestContext context) {
        log.info("Test Suite : " + context.getName() + " finished...");
        log.info("Total tests passed: " + context.getPassedTests().size());
        log.info("Total tests failed: " + context.getFailedTests().size());
        log.info("Total tests skipped: " + context.getSkippedTests().size());
    }

}
