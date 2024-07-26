package com.g2a.utils;

import com.g2a.config.DriverManager;
import io.qameta.allure.Allure;
import java.io.*;
import java.util.UUID;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtil {
  public static void takeScreenshot() {
    File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
    try (InputStream is = new FileInputStream(screenshot)) {
      byte[] bytes = is.readAllBytes();
      try (InputStream byteArrayInputStream = new ByteArrayInputStream(bytes)) {
        Allure.addAttachment(UUID.randomUUID().toString(), byteArrayInputStream);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
