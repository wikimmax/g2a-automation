package com.g2a.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[@data-locator='zth-price']")
    private WebElement priceElement;

    @FindBy(xpath = "//button[@data-locator='ppa-payment__btn']")
    private WebElement addToCartButton;

    @FindBy(xpath = "(//div[@data-test-id='dialog-container'])[6]")
    private WebElement availableOnNewAccountDialog;
    @FindBy(xpath = "//button[@data-test-id='primary-button']")
    private WebElement dialogAddToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductPrice() {
        String price = priceElement.getText();
        logger.debug("Retrieved product price: {}", price);
        return price;
    }

    public ProductPage addProductToCart() {
        logger.debug("Clicking add to cart button.");
        addToCartButton.click();
        return this;

    }

    public CartPage checkIfProductIsOnAccount(){
        if(availableOnNewAccountDialog.isDisplayed()){
            dialogAddToCartButton.click();
        }
        return new CartPage(driver);
    }


}
