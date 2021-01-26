package Cart;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.CartPageObject;
import pageobjects.ItemDetailPageObjects;
import pageobjects.StartPageObjects;


import java.io.IOException;


public class CartFeatureTests extends Base {


    //Page Actions
    StartPageObjects oStartPageActions = null;
    ItemDetailPageObjects oItemDetailsActions = null;
    CartPageObject oCartPageActions = null;

    @BeforeClass
    public void beforeClass() throws IOException {

        oStartPageActions = new StartPageObjects(myDriver);
        oItemDetailsActions = new ItemDetailPageObjects(myDriver);
        oCartPageActions = new CartPageObject(myDriver);
    }


    @AfterClass
    public void afterClass() {
        //myDriver.quit();
    }


    @Test(groups = "Cart")
    public void addToCart() {

            String textResult;


            //ON START PAGE CLICK FIRST ITEM OF THE LIST.
            //report.infoLog("Click on first item.");
            oStartPageActions.addItemToCart("Blouse");

            //IN DETAILS PAGE, CLICK ADD TO CART BUTTON
            //super.infoLog("Go to item details page.");
            oItemDetailsActions.goToDetailsPage();

            //A WINDOW WILL BE DISPLAYED, VALIDATE THE MESSAGE AND CLOSE THE WINDOW
            //report.infoLog("Verify result of the page.");
            textResult = oItemDetailsActions.getSuccessText();
            Assert.assertEquals(textResult,"Product successfully added to your shopping cart");

            //CLOSE POPUP WINDOW
            oItemDetailsActions.closeVerificationWindow();
            //report.infoLog("Close window.");
    }

    @Test(priority = 1, groups = "Cart", dependsOnMethods = "addToCart")
    public void removeItemFromCart() {
        boolean isCartEmpty;
        String emptyTextResult;


        //AFTER THE PREVIOUS TEST, STAY ON PAGE AND HOVER TO CART BUTTON
        //report.infoLog("Mouse hover and click in cart button.");
        oItemDetailsActions.naviageToCart();

        //GET AND VALIDATE THE LIST FROM CART LIST
        isCartEmpty = oCartPageActions.verifyCartNotEmpty();
        Assert.assertTrue(isCartEmpty);
        //report.infoLog("List contains an item.");
        oCartPageActions.deleteItemFromCart();
        //report.infoLog("Remove item from list");

        //VALIDATE EMPTY CART MESSAGE
        emptyTextResult = oCartPageActions.getEmptyCartMessage();
        Assert.assertEquals(emptyTextResult,"Your shopping cart is empty.");
    }


}
