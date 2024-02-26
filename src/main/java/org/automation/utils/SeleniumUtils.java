package org.automation.utils;


import org.automation.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtils {

    public static WebElement waitToBeInteractable(By by, Integer... timeout) {
        int timeToWait = timeout.length > 0 ? timeout[0] : 10;
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeToWait)).until(ExpectedConditions.elementToBeClickable(by));
    }

    public static WebElement waitForElementVisibility(By by, Integer... timeout) {
        int timeToWait = timeout.length > 0 ? timeout[0] : 10;
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeToWait)).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement getElementIfPresent(By by, Integer... timeout) {
        int timeToWait = timeout.length > 0 ? timeout[0] : 10;
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeToWait)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement moveFocusToElement(By by, Integer... timeout) {
        WebElement element = getElementIfPresent(by, timeout);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

}
