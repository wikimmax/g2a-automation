package com.g2a.pages;

import com.g2a.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
  protected static final ConfigReader configReader = ConfigReader.getInstance();
  protected final Logger logger;
  protected WebDriver driver;
  protected WebDriverWait wait;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    logger = LogManager.getLogger(getClass());
    this.wait =
        new WebDriverWait(
            driver,
            Duration.ofSeconds(Integer.parseInt(configReader.getProperty("default_timout"))));
  }

  protected void waitForUrlToContain(String partialUrl) {
    wait.until(ExpectedConditions.urlContains(partialUrl));
    logger.debug("URL contains the expected text: {}", partialUrl);
  }
}
