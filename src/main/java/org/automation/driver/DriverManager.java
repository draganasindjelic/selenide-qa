package org.automation.driver;

import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

    public static final ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    private DriverManager() {}

    public static RemoteWebDriver getDriver() {
        if (driver.get() == null ? driver.get() == null : driver.get().getSessionId() == null)
            DriverFactory.createDriver();
        return driver.get();
    }

}
