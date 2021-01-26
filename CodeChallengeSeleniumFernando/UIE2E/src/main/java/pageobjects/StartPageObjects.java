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
    private final By selectorForSearchInput = By.id("search_query_top");

    //Variable to find the search button
    private final By selectorForSearchButton = By.name("submit_search");

    //Variable to find the result text from the search
    private final By selectorForResultText = By.xpath("//span[contains(text(),'been found.')]");

    //Variable to find the list that contains the store info
    private final By selectorForFooterUl = By.xpath("//section[@id='block_contact_infos']//ul[contains(@class, 'toggle-footer')]");




    // ================================================== ACTIONS =============================================================

    public void clickAnyItem(String sTextValue){
        myDriver.findElement(selectorForCartItem(sTextValue)).click();
    }

    public void typeInSearchInputAnd(String sValue){
        myDriver.findElement(selectorForSearchInput).sendKeys(sValue);
    }

    public void clickSearchButton(){
        myDriver.findElement(selectorForSearchButton).click();
    }

    public String getResultTextAfterSearch(){
        return myDriver.findElement(selectorForResultText).getText();
    }

    public List<String> getStoreInfo(){
        List<String> sListOfResult = new ArrayList<>();
        List<WebElement> weElements =  myDriver.findElements(selectorForFooterUl);
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
