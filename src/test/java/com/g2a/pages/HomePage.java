package com.g2a.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
  @FindBy(xpath = "//input[@type='search']")
  private WebElement searchBox;

  @FindBy(xpath = "//button[@data-test-id='cookie-accept-all-btn']")
  private WebElement acceptCookiesButton;

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void open() {
    String url = configReader.getProperty("base.url");
    driver.get(url);
    logger.debug("Opened URL: {}", url);
  }

  public void searchForProduct(String productName) {
    logger.debug("Searching for product: {}", productName);
    searchBox.sendKeys(productName);
    searchBox.sendKeys(Keys.ENTER);
  }

  @SneakyThrows
  public void acceptCookies() {
    logger.debug("Clicking accept cookies button.");
    acceptCookiesButton.click();
  }
}
