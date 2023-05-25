package com.it_academy.pageobject;
import com.it_academy.framework.DriverManager;

public abstract class BasePage {

    public BasePage() {
        DriverManager.initDriver("chrome");
    }

}
