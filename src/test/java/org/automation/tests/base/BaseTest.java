package org.automation.tests.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.automation.driver.DriverManager.getDriver;

public class BaseTest {

    @BeforeEach
    public void setUpDriver() {
        getDriver(); // prvi put se kreira driver
        getDriver().get("https://demoqa.com/");
    }

    @AfterEach
    public void tearDown() {
        getDriver().quit();
    }

}
