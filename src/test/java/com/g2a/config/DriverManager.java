package com.g2a.config;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
  private static final ThreadLocal<WebDriver> driver =
      ThreadLocal.withInitial(
          () -> {
            ChromeOptions options = getChromeOptions();

            WebDriver webDriver =
                "remote".equalsIgnoreCase(System.getProperty("browserEnv"))
                    ? RemoteDriverFactory.createDriver(options)
                    : LocalDriverFactory.createDriver(options);

            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            return webDriver;
          });

  private DriverManager() {}

  public static WebDriver getDriver() {
    return driver.get();
  }

  public static void quitDriver() {
    WebDriver webDriver = driver.get();
    if (webDriver != null) {
      webDriver.quit();
      driver.remove();
    }
  }

  private static ChromeOptions getChromeOptions() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-http2");
    options.addArguments("--disable-extensions");
    options.addArguments("--disable-popup-blocking");
    options.addArguments("--incognito");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-search-engine-choice-screen");
    options.addArguments("--start-maximized");
    options.addArguments("disable-cache");
    options.addArguments("disable-application-cache");
    options.addArguments("disk-cache-size=0");
    options.addArguments(
        "user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
    options.addArguments("--disable-blink-features=AutomationControlled");
    options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
    options.setExperimentalOption("useAutomationExtension", false);
    return options;
  }
}
