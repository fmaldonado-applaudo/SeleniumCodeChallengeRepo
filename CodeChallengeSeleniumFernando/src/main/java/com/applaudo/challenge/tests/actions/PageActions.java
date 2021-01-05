package com.applaudo.challenge.tests.actions;


import com.applaudo.challenge.tests.pageobjects.CartPageObject;
import com.applaudo.challenge.tests.pageobjects.ItemDetailPageObjects;
import com.applaudo.challenge.tests.pageobjects.StartPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

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
        WebElement weElements = oStartPageObjects.getFirstItemInCart();
        weElements.click();
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
