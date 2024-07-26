package com.g2a.config;

import com.g2a.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverFactory {
    private static final ConfigReader configReader = ConfigReader.getInstance();

    public static WebDriver createDriver(ChromeOptions options) {
        WebDriver webDriver = null;
        try {
            String remoteWebDriverUrl = configReader.getProperty("remote.webdriver.url");
            webDriver = new RemoteWebDriver(new URL(remoteWebDriverUrl), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid Remote WebDriver URL", e);
        }
        return webDriver;
    }
}
