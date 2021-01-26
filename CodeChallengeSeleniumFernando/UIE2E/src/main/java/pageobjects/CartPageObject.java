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
    private final String selectorForTrashButtonByXpath = "//*[contains(@title, 'Delete')]";

    //Variable to find empty cart message
    private final String selectorForEmptyCartMessageByXpath = "//p[contains(text(),'Your shopping cart is empty.')]";

    // ================================================== LOCATE OBJECT SECTION =============================================================

    public boolean verifyCartNotEmpty(){
        try {
            WebDriverWait wdWait = new WebDriverWait(myDriver,15);
            return wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectorForTrashButtonByXpath))).isDisplayed();
        }catch (Exception eEx){
            return false;
        }
    }

    public void deleteItemFromCart(){
        myDriver.findElement(By.xpath(selectorForTrashButtonByXpath)).click();
    }

    public String getEmptyCartMessage(){
        WebDriverWait wdWait = new WebDriverWait(myDriver,15);
        return wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectorForEmptyCartMessageByXpath))).getText();
    }

}
