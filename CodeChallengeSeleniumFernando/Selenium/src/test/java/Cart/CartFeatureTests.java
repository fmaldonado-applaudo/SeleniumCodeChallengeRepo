package Cart;

import base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.CartPageObject;
import pageobjects.ItemDetailPageObjects;
import pageobjects.StartPageObjects;
import java.io.IOException;


public class CartFeatureTests extends Base {


    //Reports
    ExtentHtmlReporter htmlReporter = null;
    ExtentReports erExtent = null;
    ExtentTest etTestLogger = null;

    //Page Actions
    StartPageObjects oStartPageActions = null;
    ItemDetailPageObjects oItemDetailsActions = null;
    CartPageObject oCartPageActions = null;

    @BeforeClass
    public void beforeClass() throws IOException {

        oStartPageActions = new StartPageObjects(myDriver);
        oItemDetailsActions = new ItemDetailPageObjects(myDriver);
        oCartPageActions = new CartPageObject(myDriver);

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


    @Test(groups = "Cart")
    public void addToCartTest() {
        try {
            String sResult;

            etTestLogger = erExtent.createTest("addToCartTest");

            //ON START PAGE CLICK FIRST ITEM OF THE LIST.
            etTestLogger.log(Status.INFO,"Start Test.");
            etTestLogger.log(Status.INFO,"Click on first item.");
            oStartPageActions.clickAnyItem("Blouse");

            //IN DETAILS PAGE, CLICK ADD TO CART BUTTON
            etTestLogger.log(Status.INFO,"Go to item details page");
            oItemDetailsActions.clickAddToCartButton();

            //A WINDOW WILL BE DISPLAYED, VALIDATE THE MESSAGE AND CLOSE THE WINDOW
            etTestLogger.log(Status.INFO,"Verify result of the page.");
            sResult = oItemDetailsActions.getSuccessText();
            Assert.assertEquals(sResult,"Product successfully added to your shopping cart");
            etTestLogger.log(Status.PASS,"Expected and actual result are the same. Result: 'Product successfully added to your shopping cart'");

            //CLOSE POPUP WINDOW
            oItemDetailsActions.clickCloseButton();
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
        oItemDetailsActions.hoverInCartButtonAndClick();

        //GET AND VALIDATE THE LIST FROM CART LIST
        bValue = oCartPageActions.validateExistingItem();
        Assert.assertTrue(bValue);
        etTestLogger.log(Status.PASS,"List contains an item.");
        oCartPageActions.clickTrashButton();
        etTestLogger.log(Status.PASS,"Remove item from list");

        //VALIDATE EMPTY CART MESSAGE
        sValue = oCartPageActions.getEmptyCartMessage();
        Assert.assertEquals(sValue,"Your shopping cart is empty.");
        etTestLogger.log(Status.PASS,"Expected and Actual result are the same. Result: 'Your shopping cart is empty.'");
    }


}
