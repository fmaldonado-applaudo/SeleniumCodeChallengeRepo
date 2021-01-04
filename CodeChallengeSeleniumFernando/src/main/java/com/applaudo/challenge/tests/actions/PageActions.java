package com.applaudo.challenge.tests.actions;


import com.applaudo.challenge.tests.pageobjects.ItemDetailPageObjects;
import com.applaudo.challenge.tests.pageobjects.StartPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageActions {

    public WebDriver myDriver;
    StartPageObjects oStartPageObjects;
    ItemDetailPageObjects oItemDetailObjects;

    public PageActions(WebDriver myDriver) {
        this.myDriver = myDriver;
        oStartPageObjects = new StartPageObjects(myDriver);
        oItemDetailObjects = new ItemDetailPageObjects(myDriver);
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
}
