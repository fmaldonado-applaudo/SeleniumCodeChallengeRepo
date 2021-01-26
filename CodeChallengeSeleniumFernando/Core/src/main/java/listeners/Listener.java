package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ReportBuilder;

public class Listener implements ITestListener{

    ReportBuilder report = null;


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart");
        report.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess");
        report.passLog("Test passed!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure");
        report.errorLog("Test fail!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped");
        report.infoLog("Test skipped!");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart");
        report = new ReportBuilder();
    }

    @Override
    public void onFinish(ITestContext context) {
        report.flushReport();
        System.out.println("onFinish");
    }


}
