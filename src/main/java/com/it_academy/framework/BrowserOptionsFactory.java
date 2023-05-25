package com.it_academy.framework;

import org.openqa.selenium.remote.AbstractDriverOptions;

public class BrowserOptionsFactory {

    public static AbstractDriverOptions options;

    public static AbstractDriverOptions getBrowserOptions(String browser) {

        if (browser.equals("chrome"))
            options = BrowserOptions.getChromeOptions();
        else if (browser.equals("edge"))
            options = BrowserOptions.getEdgeOptions();
        else if (browser.equals("firefox"))
            options = BrowserOptions.getFirefoxOptions();
        else if (browser.equals("safari"))
            options = BrowserOptions.getSafariOptions();
        return options;
    }
}
