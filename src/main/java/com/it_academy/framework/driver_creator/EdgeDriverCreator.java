package com.it_academy.framework.driver_creator;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EdgeDriverCreator implements WebDriverCreator<RemoteWebDriver> {
    @Override
    public EdgeDriver create() {
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
