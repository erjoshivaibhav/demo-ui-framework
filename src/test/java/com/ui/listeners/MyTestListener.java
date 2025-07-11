package com.ui.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.BaseTest;
import com.ui.tests.LoginTest;
import com.ui.utilities.ExtentReporterUtility;
import com.ui.utilities.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener {

    private Logger log = LoggerUtility.getLogger(this.getClass());

    public void onTestStart(ITestResult result) {
        log.info("Method : " + result.getMethod().getMethodName() + " started...");
        log.info("Method Description : " + result.getMethod().getDescription());
        ExtentReporterUtility.createTest(result.getMethod().getMethodName());

    }

    public void onTestSuccess(ITestResult result) {
        log.info("Method : " + result.getMethod().getMethodName() + " PASSED");
        ExtentReporterUtility.getExtentTest().log(com.aventstack.extentreports.Status.PASS, result.getMethod().getMethodName() + " PASSED");

    }

    public void onTestFailure(ITestResult result) {
        log.error("Method : " + result.getMethod().getMethodName() + " FAILED");
        log.error("Failure description : " + result.getThrowable());
        ExtentReporterUtility.getExtentTest().log(Status.FAIL, result.getMethod().getMethodName() + " FAILED");
        ExtentReporterUtility.getExtentTest().log(Status.FAIL,result.getThrowable().getMessage());
        Object testInstance = result.getInstance();
        BaseTest baseTest = (BaseTest)testInstance;
        String path = baseTest.getInstance().takeScreenshot(result.getMethod().getMethodName());
        ExtentReporterUtility.getExtentTest().addScreenCaptureFromPath(path);

    }

    public void onTestSkipped(ITestResult result) {
        log.warn("Method : " + result.getMethod().getMethodName() + " SKIPPED");
        ExtentReporterUtility.getExtentTest().log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED");


    }

    public void onStart(ITestContext context) {

        log.info("Test Suite : " + context.getName() + " started...");
        // Initialize ExtentReports and attach the Spark reporter
        ExtentReporterUtility.setupSparkReport("report");

    }

    public void onFinish(ITestContext context) {
        log.info("Test Suite : " + context.getName() + " finished...");
        log.info("Total tests passed: " + context.getPassedTests().size());
        log.info("Total tests failed: " + context.getFailedTests().size());
        log.info("Total tests skipped: " + context.getSkippedTests().size());
        ExtentReporterUtility.flushReport(); // This will write the test results to the report file
    }

}
