package com.applaudo.challenge.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPageObject {
    public WebDriver myDriver;

    public CartPageObject(WebDriver myDriver) {
        this.myDriver = myDriver;
    }
    // ================================================== BY VARIABLE SECTION =============================================================
    
    //Variable to find trash button
    private final By selectorForTrashButton = By.xpath("//*[contains(@title, 'Delete')]");

    //Variable to find empty cart message
    private final By selectorForEmptyCartMessage = By.xpath("//p[contains(text(),'Your shopping cart is empty.')]");

    // ================================================== LOCATE OBJECT SECTION =============================================================

    /*
     * METHOD: getItemInCart
     * AUTHOR: Fernando Maldonado
     * CREATED: 04/JAN/2021- Fernando Maldonado
     * UPDATED: 04/JAN/2021- Fernando Maldonado
     */
    public WebElement getItemInCart() {
        WebDriverWait wdWait = new WebDriverWait(myDriver,15);
        return wdWait.until(ExpectedConditions.visibilityOfElementLocated(selectorForTrashButton));
    }

    /*
     * METHOD: getTrashButton
     * AUTHOR: Fernando Maldonado
     * CREATED: 04/JAN/2021- Fernando Maldonado
     * UPDATED: 04/JAN/2021- Fernando Maldonado
     */
    public WebElement getTrashButton() {
        WebDriverWait wdWait = new WebDriverWait(myDriver,15);
        return wdWait.until(ExpectedConditions.visibilityOfElementLocated(selectorForTrashButton));
    }

    /*
     * METHOD: getEmptyCartMessage
     * AUTHOR: Fernando Maldonado
     * CREATED: 04/JAN/2021- Fernando Maldonado
     * UPDATED: 04/JAN/2021- Fernando Maldonado
     */
    public WebElement getEmptyCartMessage() {
        WebDriverWait wdWait = new WebDriverWait(myDriver,15);
        return wdWait.until(ExpectedConditions.visibilityOfElementLocated(selectorForEmptyCartMessage));
    }
}
