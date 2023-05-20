package com.it_academy.pageobject;

import com.it_academy.framework.DriverManager;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BasePage {

    public BasePage() {
        DriverManager.initDriver();
    }

}
