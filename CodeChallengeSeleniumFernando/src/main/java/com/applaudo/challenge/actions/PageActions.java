package com.applaudo.challenge.actions;


import com.applaudo.challenge.pageobjects.CartPageObject;
import com.applaudo.challenge.pageobjects.ItemDetailPageObjects;
import com.applaudo.challenge.pageobjects.StartPageObjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class PageActions {

    public WebDriver myDriver;
    StartPageObjects oStartPageObjects;
    ItemDetailPageObjects oItemDetailObjects;
    CartPageObject oCartPageObjects;

    public PageActions(WebDriver myDriver) {
        this.myDriver = myDriver;
        oStartPageObjects = new StartPageObjects(myDriver);
        oItemDetailObjects = new ItemDetailPageObjects(myDriver);
        oCartPageObjects = new CartPageObject(myDriver);
    }

    //==========================================================START PAGE ACTIONS==========================================================
    public void clickFirstItem(){
        WebElement weElements = oStartPageObjects.getFirstItemInCart("Blouse");
        weElements.click();
    }

    public void typeInSearchInputAnd(String sValue){
        WebElement weElements = oStartPageObjects.getSearchInput();
        weElements.sendKeys(sValue);
    }

    public void clickSearchButton(){
        WebElement weElements = oStartPageObjects.getSearchButton();
        weElements.click();
    }

    public String getResultTextAfterSearch(){
        WebElement weElements = oStartPageObjects.getResultText();
        return weElements.getText();
    }

    public List<String> getStoreInfo(){
        List<String> sListOfResult = new ArrayList<String>();
        List<WebElement> weElements = oStartPageObjects.getFooterStoreInfo();
        for (WebElement weElement : weElements) {
            sListOfResult.add(weElement.getText());
        }
        return sListOfResult;
    }

    public void scrollToBottom(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor)myDriver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //==========================================================ITEM DETAILS PAGE ACTIONS====================================================
    public void clickAddToCartButton(){
        WebElement weElement = oItemDetailObjects.getAddToCartButton();
        weElement.click();
    }

    public String getSuccessText(){
        WebElement weElement = oItemDetailObjects.getSuccessText();
        return weElement.getText();
    }

    public void clickCloseButton(){
        WebElement weElement = oItemDetailObjects.getCloseButton();
        weElement.click();
    }

    public void hoverInCartButtonAndClick(){
        WebElement weElement = oItemDetailObjects.getCartButton();

        Actions aActions = new Actions(myDriver);
        Action mouseOverButton = aActions
                .moveToElement(weElement)
                .build();
        mouseOverButton.perform();

        weElement.click();
    }

    //==========================================================CART PAGE ACTIONS====================================================
    public boolean validateExistingItem(){
        try {
            WebElement weElement = oCartPageObjects.getItemInCart();
            return weElement.isDisplayed();
        }catch (Exception eEx){
            return false;
        }
    }

    public void clickTrashButton(){
        WebElement weElement = oCartPageObjects.getTrashButton();
        weElement.click();
    }

    public String getEmptyCartMessage(){
        WebElement weElement = oCartPageObjects.getEmptyCartMessage();
        return weElement.getText();
    }
}
