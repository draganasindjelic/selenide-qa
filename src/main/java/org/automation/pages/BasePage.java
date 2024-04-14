package org.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.automation.driver.DriverManager.getDriver;

public class BasePage {

    public WebElement waitToBeInteractable(By by, Integer... timeout) {
        int timeToWait = timeout.length > 0 ? timeout[0] : 10;
        return new WebDriverWait(getDriver(), Duration.ofSeconds(timeToWait)).until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitForElementVisibility(By by, Integer... timeout) {
        int timeToWait = timeout.length > 0 ? timeout[0] : 10;
        return new WebDriverWait(getDriver(), Duration.ofSeconds(timeToWait)).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement getElementIfPresent(By by, Integer... timeout) {
        int timeToWait = timeout.length > 0 ? timeout[0] : 10;
        return new WebDriverWait(getDriver(), Duration.ofSeconds(timeToWait)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement moveFocusToElement(By by, Integer... timeout) {
        WebElement element = getElementIfPresent(by, timeout);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

}
