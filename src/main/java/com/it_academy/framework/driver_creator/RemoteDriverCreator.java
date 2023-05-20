package com.it_academy.framework.driver_creator;

import com.it_academy.framework.BrowserOptionsFactory;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverCreator implements WebDriverCreator<RemoteWebDriver> {

    @Override
    public RemoteWebDriver create() {
        try {
            return new RemoteWebDriver(new URL("http://192.168.0.111:4444"),
                    BrowserOptionsFactory.getBrowserOptions(System.getProperty("remoteBrowser")));
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }
}
