package com.applaudo.challenge.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemDetailPageObjects {
    public WebDriver myDriver;

    public ItemDetailPageObjects(WebDriver myDriver) {
        this.myDriver = myDriver;
    }
    // ================================================== BY VARIABLE SECTION =============================================================

    //Variable to find "Add to cart" Button
    private final By selectorForAddToCart = By.name("Submit");

    //Variable to find the success text from the popup window
    private final By selectorForSuccessText = By.xpath("//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[1]/h2[1]");

    //Variable to find the close button in the popup window
    private final By selectorForCloseButton = By.cssSelector(".cross");

    // ================================================== LOCATE OBJECT SECTION =============================================================

    /*
     * METHOD: getAllLiFromUl
     * AUTHOR: Fernando Maldonado
     * CREATED: 04/JAN/2021- Fernando Maldonado
     * UPDATED: 04/JAN/2021- Fernando Maldonado
     */
    public WebElement getAddToCartButton() {
        WebDriverWait wdWait = new WebDriverWait(myDriver,15);
        return wdWait.until(ExpectedConditions.visibilityOfElementLocated(selectorForAddToCart));
    }

    /*
     * METHOD: getSuccessText
     * AUTHOR: Fernando Maldonado
     * CREATED: 04/JAN/2021- Fernando Maldonado
     * UPDATED: 04/JAN/2021- Fernando Maldonado
     */
    public WebElement getSuccessText() {
        WebDriverWait wdWait = new WebDriverWait(myDriver,15);
        return wdWait.until(ExpectedConditions.visibilityOfElementLocated(selectorForSuccessText));
    }

    /*
     * METHOD: getCloseButton
     * AUTHOR: Fernando Maldonado
     * CREATED: 04/JAN/2021- Fernando Maldonado
     * UPDATED: 04/JAN/2021- Fernando Maldonado
     */
    public WebElement getCloseButton() {
        WebDriverWait wdWait = new WebDriverWait(myDriver,15);
        return wdWait.until(ExpectedConditions.visibilityOfElementLocated(selectorForCloseButton));
    }
}
