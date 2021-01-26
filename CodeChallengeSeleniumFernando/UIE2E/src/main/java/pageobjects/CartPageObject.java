package pageobjects;

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

    public boolean validateExistingItem(){
        try {
            WebDriverWait wdWait = new WebDriverWait(myDriver,15);
            return wdWait.until(ExpectedConditions.visibilityOfElementLocated(selectorForTrashButton)).isDisplayed();
        }catch (Exception eEx){
            return false;
        }
    }

    public void clickTrashButton(){
        myDriver.findElement(selectorForTrashButton).click();
    }

    public String getEmptyCartMessage(){
        WebDriverWait wdWait = new WebDriverWait(myDriver,15);
        return wdWait.until(ExpectedConditions.visibilityOfElementLocated(selectorForEmptyCartMessage)).getText();
    }

}
