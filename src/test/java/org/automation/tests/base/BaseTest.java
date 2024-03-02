package org.automation.tests.base;

import org.automation.configuration.factory.ConfigFactory;
import org.automation.driver.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUpDriver() {
        driver = DriverFactory.startLocalBrowser(ConfigFactory.getConfig().browser());
        assert driver != null;
        driver.get("https://demoqa.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

   /* private static final FrameworkConfig CONFIG = ConfigFactory.getConfig();

    @BeforeEach
    public void setUp() {
        DriverFactory.createDriver();
    }

    @AfterEach
    public void tearDown() {
        DriverManager.getDriver().quit();
    }*/
}
