package Search;

import base.Base;
import dataproviders.DataProviders;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.StartPageObjects;
import java.io.IOException;

public class SearchFeatureTests extends Base {

    //Reports
    ExtentHtmlReporter htmlReporter = null;
    ExtentReports erExtent = null;
    ExtentTest etTestLogger = null;

    //Page Actions
    StartPageObjects oStartPageActions = null;

    @BeforeClass
    public void beforeClass() throws IOException {

        oStartPageActions = new StartPageObjects(myDriver);

        // start reporters
        htmlReporter = new ExtentHtmlReporter("./Reports/ChallengeTest.html");

        // create ExtentReports and attach reporter(s)
        erExtent = new ExtentReports();

        erExtent.attachReporter(htmlReporter);
    }


    @AfterClass
    public void afterClass() {
        erExtent.flush();
        //myDriver.quit();
    }


    @Test(priority = 3, groups = "Search", dataProvider = "searchValue", dataProviderClass = DataProviders.class)
    public void searchItems(String sValue, String sType) {
        String sResult;

        if(sType.equals("Positive")){
            etTestLogger = erExtent.createTest("Valid searchItems");
        }else{
            etTestLogger = erExtent.createTest("Invalid searchItems");
        }

        //TYPE THE VALUE IN THE SEARCH INPUT
        etTestLogger.log(Status.INFO,"Start Test.");
        etTestLogger.log(Status.INFO,"Insert the value: " + sValue);
        oStartPageActions.typeInSearchInputAnd(sValue);

        //CLICK SEARCH BUTTON AND VALIDATE THE RESULT
        etTestLogger.log(Status.INFO,"Click search button.");
        oStartPageActions.clickSearchButton();
        sResult = oStartPageActions.getResultTextAfterSearch();
        if(sType.equals("Negative")){
            //INVALID VALUES VALIDATION
            Assert.assertEquals(sResult,"0 results have been found.");
            etTestLogger.log(Status.PASS,"Invalid value search passed. Value: " + sValue);
        }else{
            //VALID VALUES VALIDATION
            Assert.assertTrue(sResult.contains("results has been found.") || sResult.contains("result has been found."));
            etTestLogger.log(Status.PASS,"Valid value search passed. Value: " + sValue);
        }
    }
}
