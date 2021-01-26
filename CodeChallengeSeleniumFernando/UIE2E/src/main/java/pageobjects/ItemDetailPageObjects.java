package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ItemDetailPageObjects {
    public WebDriver myDriver;

    public ItemDetailPageObjects(WebDriver myDriver) {
        this.myDriver = myDriver;
    }
    // ================================================== BY VARIABLE SECTION =============================================================

    //Variable to find "Add to cart" Button
    private final String selectorForAddToCartByName = "Submit";

    //Variable to find the success text from the popup window
    private final String selectorForSuccessTextByXpath = "//*[contains(@class, 'layer_cart_product col-xs-12 col-md-6')]//h2";

    //Variable to find the close button in the popup window
    private final String selectorForCloseButtonByCssSelector = ".cross";

    //Variable to find the cart button
    private final String selectorForCartButtonByXpath = "//a[contains(@title, 'View my shopping cart')]";



    // ================================================== ACTIONS =============================================================

    public void goToDetailsPage(){
        myDriver.findElement(By.name(selectorForAddToCartByName)).click();
    }

    public String getSuccessText(){
        WebDriverWait wdWait = new WebDriverWait(myDriver,15);
        return wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectorForSuccessTextByXpath))).getText();
    }

    public void closeVerificationWindow(){
        myDriver.findElement(By.cssSelector(selectorForCloseButtonByCssSelector)).click();
    }

    public void naviageToCart(){
        WebElement weElement = myDriver.findElement(By.xpath(selectorForCartButtonByXpath));

        Actions aActions = new Actions(myDriver);
        Action mouseOverButton = aActions
                .moveToElement(weElement)
                .build();
        mouseOverButton.perform();

        weElement.click();
    }

}
