package com.it_academy.framework;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;

public class DriverManager {

    public static void initDriver() {
//        Configuration.browser = "chrome";
        Configuration.browser = DriverProvider.class.getName();
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 200000;
        open();
    }

}

