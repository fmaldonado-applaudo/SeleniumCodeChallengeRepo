package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportBuilder {
    //Reports
    protected ExtentHtmlReporter htmlReporter = null;
    protected ExtentReports erExtent = null;
    protected ExtentTest etTestLogger = null;

    public ReportBuilder(){
        htmlReporter = new ExtentHtmlReporter("./Reports/E2ETestReport.html");
        erExtent = new ExtentReports();
        erExtent.attachReporter(htmlReporter);
    }

    public void flushReport(){
        erExtent.flush();
    }

    public void createTest(String testName){
        etTestLogger = erExtent.createTest("Start Test: " + testName);
    }

    public void errorLog(String logMessage){
        etTestLogger.log(Status.ERROR,logMessage);
    }

    public void infoLog(String logMessage){
        etTestLogger.log(Status.INFO,logMessage);
    }

    public void passLog(String logMessage){
        etTestLogger.log(Status.PASS,logMessage);
    }
}
