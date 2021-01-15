package selenium;

import base.Base;
import com.applaudo.challenge.actions.PageActions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;


public class CartFeatureTests extends Base {


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


}
