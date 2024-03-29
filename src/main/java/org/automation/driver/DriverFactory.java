package org.automation.driver;

import org.automation.configuration.factory.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static void createDriver() {
        if (ConfigFactory.getConfig().runMode().equals("remote")) {
            //remote WebDriver setup
        } else {
            createLocalBrowser(ConfigFactory.getConfig().browser());
        }
    }

    private static void createLocalBrowser(String browser) {
        if (browser.equals("chrome")) {
            ChromeDriver driver = new ChromeDriver();
            DriverManager.driver.set(driver);
            DriverManager.driver.get().manage().window().maximize();
            DriverManager.driver.get().manage().deleteAllCookies();
        } else if (browser.equals("firefox")) {
            FirefoxDriver driver = new FirefoxDriver();
            DriverManager.driver.set(driver);
            DriverManager.driver.get().manage().window().maximize();
            DriverManager.driver.get().manage().deleteAllCookies();
        }
    }

    public static WebDriver startLocalBrowser(String browser) {

        if (browser.equals("chrome")) {
            ChromeDriver driver = new ChromeDriver();
            DriverManager.driver.set(driver);
            DriverManager.driver.get().manage().window().maximize();
            DriverManager.driver.get().manage().deleteAllCookies();
            return driver;
        } else if (browser.equals("firefox")) {
            FirefoxDriver driver = new FirefoxDriver();
            DriverManager.driver.set(driver);
            DriverManager.driver.get().manage().window().maximize();
            DriverManager.driver.get().manage().deleteAllCookies();
            return driver;
        }
        return null;
    }
}
