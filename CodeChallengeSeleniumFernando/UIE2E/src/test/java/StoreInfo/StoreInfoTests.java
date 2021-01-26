package StoreInfo;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.StartPageObjects;
import java.io.IOException;
import java.util.List;

public class StoreInfoTests extends Base {



    //Page Actions
    StartPageObjects oStartPageActions = null;

    @BeforeClass
    public void beforeClass() throws IOException {

        oStartPageActions = new StartPageObjects(myDriver);

    }

    @AfterClass
    public void afterClass() {
        //myDriver.quit();
    }

    @Test(groups = "Store")
    public void validateStoreInformation() {


            //SCROLL TO BOTTOM
            //etTestLogger.log(Status.INFO, "Start Test.");
            oStartPageActions.scrollToBottom();
           // etTestLogger.log(Status.PASS, "Scroll to bottom.");

            //GET THE STORE INFORMATION
            List<String> listOfStoreInformation = oStartPageActions.getStoreInfo();
            for (String storeInformation : listOfStoreInformation) {
                System.out.println(storeInformation);
                //etTestLogger.log(Status.INFO, "Validate: " + storeInformation);
                Assert.assertTrue(storeInformation.contains("Selenium Framework, Research Triangle Park, North Carolina, USA") || storeInformation.contains("Call us now: (347) 466-7432") || storeInformation.contains("Email: support@seleniumframework.com"));
            }
    }
}
