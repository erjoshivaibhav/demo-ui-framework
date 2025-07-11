package com.ui.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {
    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    public static void setupSparkReport(String reportName){
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//"+reportName+".html");//PLease go ahead and create a report.html file in the project root directory
        extentReports = new ExtentReports();// This is used to generate the report(heavy lifting, data that needs to be dumped)
        extentReports.attachReporter(extentSparkReporter);//
    }

    public static void createTest(String testName){
        ExtentTest test = extentReports.createTest(testName);
        extentTest.set(test);
    }

    public static ExtentTest getExtentTest() {
        return extentTest.get();
    }

    public  static void flushReport() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}
