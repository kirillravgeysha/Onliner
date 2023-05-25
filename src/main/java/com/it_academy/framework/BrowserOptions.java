package com.it_academy.framework;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

import java.util.ArrayList;
import java.util.HashMap;

public class BrowserOptions {

    public static ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "113.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test badge...");
            put("enableVNC", true);
            put("enableLog", true);
            put("logName", "log.log");
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});
//            /* How to enable video recording */
//            put("enableVideo", true);
        }});
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        return options;
    }

    public static FirefoxOptions getFirefoxOptions(){
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("browserVersion", "113.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test badge...");
            put("enableVNC", true);
            put("enableLog", true);
            put("logName", "log.log");
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});
//            /* How to enable video recording */
//            put("enableVideo", true);
        }});
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        return options;
    }

    public static EdgeOptions getEdgeOptions(){
        EdgeOptions options = new EdgeOptions();
        options.setPlatformName(Platform.WIN10.name());
        options.setCapability("browserName", "edge");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        return options;
    }

    public static SafariOptions getSafariOptions(){
        SafariOptions options = new SafariOptions();
        options.setCapability("browserVersion", "15.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test badge...");
            put("enableVNC", true);
            put("enableLog", true);
            put("logName", "log.log");
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});
//            /* How to enable video recording */
//            put("enableVideo", true);
        }});
        return options;
    }

}
