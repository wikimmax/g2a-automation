package com.g2a.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocalDriverFactory {
    public static WebDriver createDriver(ChromeOptions options) {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }
}
