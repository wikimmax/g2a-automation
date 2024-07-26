package com.g2a.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(xpath = "//span[@data-locator='zth-price']")
    private WebElement cartPriceElement;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartPrice() {
        String price = cartPriceElement.getText();
        logger.debug("Retrieved cart price: {}", price);
        return price;
    }

    public CartPage waitForCartPageToLoad(){
        waitForUrlToContain("cart");
        return this;
    }
}
