package com.it_academy.test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/CucumberTestRunner.html",
                "json:target/cucumber-reports/CucumberTestRunner.json",
                "junit:target/cucumber-reports/CucumberTestRunner.xml"},
        monochrome = true,
        glue = {"com.it_academy.test.steps", "com.it_academy.test.hooks"},
        features = "src/test/resources/com.it_academy.test.features/AddToCart.feature"

)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}
