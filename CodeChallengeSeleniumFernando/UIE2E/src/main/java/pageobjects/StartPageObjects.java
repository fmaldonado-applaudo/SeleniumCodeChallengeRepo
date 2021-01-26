package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class StartPageObjects {
    public WebDriver myDriver;

    public StartPageObjects(WebDriver myDriver) {
        this.myDriver = myDriver;
    }
    // ================================================== BY VARIABLE SECTION =============================================================

    //Variable to find an element from the list
    private By selectorForCartItem(String sSearchText) {
        return By.linkText(sSearchText);
        //return By.xpath("//a[contains(text(),'" + sSearchText + "')]");
    }

    //Variable to find the search input
    private final String selectorForSearchInputById = "search_query_top";

    //Variable to find the search button
    private final String selectorForSearchButtonByName ="submit_search";

    //Variable to find the result text from the search
    private final String selectorForResultTextByXpath = "//span[contains(text(),'been found.')]";

    //Variable to find the list that contains the store info
    private final String selectorForFooterUlByXpath = "//section[@id='block_contact_infos']//ul[contains(@class, 'toggle-footer')]";




    // ================================================== ACTIONS =============================================================

    public void addItemToCart(String sTextValue){
        myDriver.findElement(selectorForCartItem(sTextValue)).click();
    }

    public void typeItemInSearchBar(String sValue){
        myDriver.findElement( By.id(selectorForSearchInputById)).sendKeys(sValue);
    }

    public void searchForAnItem(){
        myDriver.findElement(By.name(selectorForSearchButtonByName)).click();
    }

    public String getResultTextAfterSearch(){
        return myDriver.findElement(By.xpath(selectorForResultTextByXpath)).getText();
    }

    public List<String> getStoreInfo(){
        List<String> sListOfResult = new ArrayList<>();
        List<WebElement> weElements =  myDriver.findElements(By.xpath(selectorForFooterUlByXpath));
        for (WebElement weElement : weElements) {
            sListOfResult.add(weElement.getText());
        }
        return sListOfResult;
    }

    public void scrollToBottom(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor)myDriver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
