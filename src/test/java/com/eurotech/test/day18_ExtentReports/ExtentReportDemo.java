package com.eurotech.test.day18_ExtentReports;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    //This class is used for starting and building reports
    ExtentReports report;

    //This class is used to create HTML report files
    ExtentHtmlReporter htmlReporter;

    //This will define a test, enable adding logs, authors and test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){

        //initialize the class
        report = new ExtentReports();

        //create a report path --> how can we find our project dynamicly
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        //initialize the html report with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to the report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("EuroTech Smoke Test");

        //Set environment information
        report.setSystemInfo("Environment", "Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer","Emre");

    }
    @Test
    public void test1(){
        //Give a name to the current test
        extentLogger = report.createTest("TC01 Login Test");

        //Test steps
        extentLogger.info("Open the browser");

        extentLogger.info("go to url http://eurotech.study/login");

        extentLogger.info("Login as Teacher");

        extentLogger.info("Enter teacher user name");

        extentLogger.info("Enter teacher password");

        extentLogger.info("Click login button");

        extentLogger.info("Verify logged in");

        extentLogger.info("TC01 Login Test is passed");
    }
    @AfterMethod
    public void tearDown(){
        //This is when the report is actually created
        report.flush();
    }

}
