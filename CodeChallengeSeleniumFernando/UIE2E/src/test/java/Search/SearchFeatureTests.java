package Search;

import base.Base;
import dataproviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.StartPageObjects;
import java.io.IOException;

public class SearchFeatureTests extends Base {


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


    @Test(priority = 3, groups = "Search", dataProvider = "searchValue", dataProviderClass = DataProviders.class)
    public void searchItems(String searchValue, String dataType) {
        String resultFromSearch;

        if(dataType.equals("Positive")){
           // etTestLogger = erExtent.createTest("Valid searchItems");
        }else{
            //etTestLogger = erExtent.createTest("Invalid searchItems");
        }

        //TYPE THE VALUE IN THE SEARCH INPUT
       // etTestLogger.log(Status.INFO,"Start Test.");
        //etTestLogger.log(Status.INFO,"Insert the value: " + searchValue);
        oStartPageActions.typeItemInSearchBar(searchValue);

        //CLICK SEARCH BUTTON AND VALIDATE THE RESULT
        //etTestLogger.log(Status.INFO,"Click search button.");
        oStartPageActions.searchForAnItem();
        resultFromSearch = oStartPageActions.getResultTextAfterSearch();
        if(dataType.equals("Negative")){
            //INVALID VALUES VALIDATION
            Assert.assertEquals(resultFromSearch,"0 results have been found.");
        }else{
            //VALID VALUES VALIDATION
            Assert.assertTrue(resultFromSearch.contains("results has been found.") || resultFromSearch.contains("result has been found."));
        }
    }
}
