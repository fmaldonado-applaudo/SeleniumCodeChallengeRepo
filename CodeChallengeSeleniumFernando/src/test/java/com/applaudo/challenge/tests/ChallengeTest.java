package com.applaudo.challenge.tests;

import com.applaudo.challenge.tests.base.Base;
import com.applaudo.challenge.tests.utilities.Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.*;

import java.io.IOException;

public class ChallengeTest  extends Base {
    String sPageUrl = "http://automationpractice.com/index.php";
    Utilities oUtilities = null;
    ExtentHtmlReporter htmlReporter = null;
    ExtentReports erExtent = null;
    ExtentTest etTestLogger = null;

    @BeforeClass
    public void beforeClass() throws IOException {
        myDriver = initializeDriver();
        myDriver.get(sPageUrl);
        myDriver.manage().window().maximize();
        oUtilities = new Utilities();

        // start reporters
        htmlReporter = new ExtentHtmlReporter("./Reports/ChallengeTest.html");

        // create ExtentReports and attach reporter(s)
        erExtent = new ExtentReports();
        erExtent.attachReporter(htmlReporter);
    }



    @AfterClass
    public void afterClass() {
        erExtent.flush();
        myDriver.quit();
    }


    @Test
    public void myTestOne() {
        System.out.println("testOne");
        etTestLogger = erExtent.createTest("myTestOne");
        etTestLogger.log(Status.INFO,"Run Test One Done!");
    }

    @Test
    public void myTestTwo() {
        System.out.println("testTwo");
        etTestLogger = erExtent.createTest("myTestTwo");
        etTestLogger.log(Status.INFO,"Run Test Two Done!");
    }
}
