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
    private final By selectorForAddToCart = By.name("Submit");

    //Variable to find the success text from the popup window
    private final By selectorForSuccessText = By.xpath("//*[contains(@class, 'layer_cart_product col-xs-12 col-md-6')]//h2");

    //Variable to find the close button in the popup window
    private final By selectorForCloseButton = By.cssSelector(".cross");

    //Variable to find the cart button
    private final By selectorForCartButton = By.xpath("//a[contains(@title, 'View my shopping cart')]");



    // ================================================== ACTIONS =============================================================

    public void clickAddToCartButton(){
        myDriver.findElement(selectorForAddToCart).click();
    }

    public String getSuccessText(){
        WebDriverWait wdWait = new WebDriverWait(myDriver,15);
        return wdWait.until(ExpectedConditions.visibilityOfElementLocated(selectorForSuccessText)).getText();
    }

    public void clickCloseButton(){
        myDriver.findElement(selectorForCloseButton).click();
    }

    public void hoverInCartButtonAndClick(){
        WebElement weElement = myDriver.findElement(selectorForCartButton);

        Actions aActions = new Actions(myDriver);
        Action mouseOverButton = aActions
                .moveToElement(weElement)
                .build();
        mouseOverButton.perform();

        weElement.click();
    }

}
