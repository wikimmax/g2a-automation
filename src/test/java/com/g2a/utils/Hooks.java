package com.g2a.utils;

import com.g2a.config.DriverManager;
import io.cucumber.java.*;

public class Hooks {

    @Before
    public void setUp() {
        DriverManager.getDriver();
    }

    @After
    public void tearDown() {
        ScreenshotUtil.takeScreenshot();
        DriverManager.quitDriver();
    }

}
