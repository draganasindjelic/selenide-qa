package org.automation.tests.base;

import org.automation.configuration.FrameworkConfig;
import org.automation.configuration.factory.ConfigFactory;
import org.automation.driver.DriverFactory;
import org.automation.driver.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    private static final FrameworkConfig CONFIG = ConfigFactory.getConfig();

    @BeforeEach
    public void setUp() {
        DriverFactory.createDriver();
    }

    @AfterEach
    public void tearDown() {
        DriverManager.getDriver().quit();
    }
}
