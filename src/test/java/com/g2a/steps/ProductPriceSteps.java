package com.g2a.steps;

import static com.g2a.utils.ScreenshotUtil.takeScreenshot;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.g2a.config.DriverManager;
import com.g2a.context.ProductTestContext;
import com.g2a.pages.CartPage;
import com.g2a.pages.HomePage;
import com.g2a.pages.ProductPage;
import com.g2a.pages.SearchPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class ProductPriceSteps {
  private static final ThreadLocal<ProductTestContext> productContext =
      ThreadLocal.withInitial(ProductTestContext::new);
  private final HomePage homePage;
  private final ProductPage productPage;
  private final CartPage cartPage;
  private final SearchPage searchPage;

  public ProductPriceSteps() {
    WebDriver driver = DriverManager.getDriver();
    homePage = new HomePage(driver);
    productPage = new ProductPage(driver);
    cartPage = new CartPage(driver);
    searchPage = new SearchPage(driver);
  }

  @Given("I am on the homepage")
  public void iAmOnTheHomepage() {
    homePage.open();
    homePage.acceptCookies();
    takeScreenshot();
  }

  @When("I search for the product")
  public void iSearchForTheProduct() {
    String productName = System.getProperty("productName");
    if (productName == null || productName.isEmpty()) {
      throw new IllegalArgumentException("Product name must be specified as a system property.");
    }
    homePage.searchForProduct(productName);
    takeScreenshot();
    searchPage.clickOnProduct(0);
  }

  @When("I record the price of the product")
  public void iRecordThePriceOfTheProduct() {
    String productPrice = productPage.getProductPrice();
    productContext.get().setProductPrice(productPrice);
    takeScreenshot();
  }

  @When("I add the product to the cart")
  public void iAddTheProductToTheCart() {
    takeScreenshot();
    productPage.addProductToCart()
            .checkIfProductIsOnAccount()
            .waitForCartPageToLoad();
  }

  @Then("the price in the cart should be the same as the product page")
  public void thePriceInTheCartShouldBeTheSameAsTheProductPage() {
    String cartPrice = cartPage.getCartPrice();
    String recordedPrice = productContext.get().getProductPrice();
    assertEquals(recordedPrice, cartPrice);
    takeScreenshot();
  }
}
