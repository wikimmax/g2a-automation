package com.g2a.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//ul[contains(@class, 'StyledListMobile')]//li")
    private List<WebElement> productsList;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnProduct(int productIndex) {
        logger.debug("Clicking on product at index: {}", productIndex);
        productsList.get(productIndex).click();
    }
}
