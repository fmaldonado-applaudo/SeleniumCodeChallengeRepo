package com.applaudo.challenge.tests.selenium;

import com.applaudo.challenge.tests.actions.PageActions;
import com.applaudo.challenge.tests.base.Base;
import com.applaudo.challenge.tests.dataproviders.DataProviders;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.List;

public class ChallengeTest  extends Base {


    //Reports
    ExtentHtmlReporter htmlReporter = null;
    ExtentReports erExtent = null;
    ExtentTest etTestLogger = null;

    //Page Actions
    PageActions oTestPageAction = null;

    @BeforeClass
    public void beforeClass() throws IOException {

        oTestPageAction = new PageActions(myDriver);

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


    @Test(groups = "Cart")
    public void addToCartTest() {
        try {
            String sResult;

            etTestLogger = erExtent.createTest("addToCartTest");

            //ON START PAGE CLICK FIRST ITEM OF THE LIST.
            etTestLogger.log(Status.INFO,"Start Test.");
            etTestLogger.log(Status.INFO,"Click on first item.");
            oTestPageAction.clickFirstItem();

            //IN DETAILS PAGE, CLICK ADD TO CART BUTTON
            etTestLogger.log(Status.INFO,"Go to item details page");
            oTestPageAction.clickAddToCartButton();

            //A WINDOW WILL BE DISPLAYED, VALIDATE THE MESSAGE AND CLOSE THE WINDOW
            etTestLogger.log(Status.INFO,"Verify result of the page.");
            sResult = oTestPageAction.getSuccessText();
            Assert.assertEquals(sResult,"Product successfully added to your shopping cart");
            etTestLogger.log(Status.PASS,"Expected and actual result are the same. Result: 'Product successfully added to your shopping cart'");

            //CLOSE POPUP WINDOW
            oTestPageAction.clickCloseButton();
            etTestLogger.log(Status.INFO,"Close window.");

        }catch (Exception eEx) {
            etTestLogger.log(Status.FAIL,"Error: " + eEx);
            Assert.fail();
        }
    }

    @Test(priority = 1, groups = "Cart", dependsOnMethods = "addToCartTest")
    public void removeItemFromCart() {
        boolean bValue;
        String sValue;

        etTestLogger = erExtent.createTest("removeItemFromCart");
        //AFTER THE PREVIOUS TEST, STAY ON PAGE AND HOVER TO CART BUTTON
        etTestLogger.log(Status.INFO,"Start Test.");
        etTestLogger.log(Status.INFO,"Mouse hover and click in cart button.");
        oTestPageAction.hoverInCartButtonAndClick();

        //GET AND VALIDATE THE LIST FROM CART LIST
        bValue = oTestPageAction.validateExistingItem();
        Assert.assertTrue(bValue);
        etTestLogger.log(Status.PASS,"List contains an item.");
        oTestPageAction.clickTrashButton();
        etTestLogger.log(Status.PASS,"Remove item from list");

        //VALIDATE EMPTY CART MESSAGE
        sValue = oTestPageAction.getEmptyCartMessage();
        Assert.assertEquals(sValue,"Your shopping cart is empty.");
        etTestLogger.log(Status.PASS,"Expected and Actual result are the same. Result: 'Your shopping cart is empty.'");
    }

    @Test(priority = 3, groups = "Search", dataProvider = "searchValue", dataProviderClass = DataProviders.class)
    public void searchItems(String sValue) {
        String sResult;

        if(sValue.equals("Skirt")){
            etTestLogger = erExtent.createTest("Valid searchItems");
        }else{
            etTestLogger = erExtent.createTest("Invalid searchItems");
        }

        //TYPE THE VALUE IN THE SEARCH INPUT
        etTestLogger.log(Status.INFO,"Start Test.");
        etTestLogger.log(Status.INFO,"Insert the value: " + sValue);
        myDriver.get("http://automationpractice.com/index.php");
        oTestPageAction.typeInSearchInputAnd(sValue);

        //CLICK SEARCH BUTTON AND VALIDATE THE RESULT
        etTestLogger.log(Status.INFO,"Click search button.");
        oTestPageAction.clickSearchButton();
        sResult = oTestPageAction.getResultTextAfterSearch();
        if(sResult.equals("0 results have been found.")){
            //INVALID VALUES VALIDATION
            etTestLogger.log(Status.PASS,"Invalid value search passed. Value: " + sValue);
        }else{
            //VALID VALUES VALIDATION
            if(sResult.contains("results has been found.") || sResult.contains("result has been found.")){
                etTestLogger.log(Status.PASS,"Valid value search passed. Value: " + sValue);
            }else {
                etTestLogger.log(Status.FAIL,"Expected and actual results are different.");
            }
        }
    }

    @Test(groups = "Store")
    public void validateStoreInformation() {
        try {
            etTestLogger = erExtent.createTest("validateStoreInformation");

            //SCROLL TO BOTTOM
            etTestLogger.log(Status.INFO, "Start Test.");
            oTestPageAction.scrollToBottom();
            etTestLogger.log(Status.PASS, "Scroll to bottom.");

            //GET THE STORE INFORMATION
            List<String> sListOfResult = oTestPageAction.getStoreInfo();
            for (String sElement : sListOfResult) {
                System.out.println(sElement);
                etTestLogger.log(Status.INFO, "Validate: " + sElement);
                Assert.assertTrue(sElement.equals("Selenium Framework, Research Triangle Park, North Carolina, USA") || sElement.equals("Call us now: (347) 466-7432") || sElement.equals("Email: support@seleniumframework.com"));
                etTestLogger.log(Status.PASS, "Pass: " + sElement);
            }
        }catch (Exception eEx){
            etTestLogger.log(Status.FAIL,"Error: " + eEx);
            Assert.fail();
        }
    }
}
