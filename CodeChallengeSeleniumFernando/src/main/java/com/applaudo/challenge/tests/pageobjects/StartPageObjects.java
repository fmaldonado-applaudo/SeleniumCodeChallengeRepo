package com.applaudo.challenge.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPageObjects {
    public WebDriver myDriver;

    public StartPageObjects(WebDriver myDriver) {
        this.myDriver = myDriver;
    }
    // ================================================== BY VARIABLE SECTION =============================================================

    //Variable to find an element from the list
    private final By selectorForCartItem = By.xpath("//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]");



    // ================================================== LOCATE OBJECT SECTION =============================================================

    /*
     * METHOD: getFirstItemInCart
     * AUTHOR: Fernando Maldonado
     * CREATED: 29/DIC/2020- Fernando Maldonado
     * UPDATED: 29/DIC/2020- Fernando Maldonado
     */
    public WebElement getFirstItemInCart() {
        WebDriverWait wdWait = new WebDriverWait(myDriver,15);
        return wdWait.until(ExpectedConditions.visibilityOfElementLocated(selectorForCartItem));
    }
}
