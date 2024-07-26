package com.g2a;

import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.*;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameters({
  @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:target/cucumber/cucumber.json"),
  @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.g2a.steps,com.g2a.utils"),
  @ConfigurationParameter(
      key = PLUGIN_PROPERTY_NAME,
      value = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm")
})
public class RunCucumberTest {}
