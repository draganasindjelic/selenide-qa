package org.automation.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeFormTest {

    WebDriver driver;

    @Test
    public void practiceFormTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        moveFocusToElement(By.xpath("//h5[text()='Forms']")).click();
        driver.findElement(By.xpath("//*[text()='Practice Form']")).click();
        driver.findElement(By.id("firstName")).sendKeys("Dragana");
        driver.findElement(By.id("lastName")).sendKeys("Sindjelic");
        driver.findElement(By.id("userEmail")).sendKeys("dragana9290@gmail.com");
        moveFocusToElement(By.cssSelector("[for=gender-radio-2]"));
        waitForElementVisibility(By.cssSelector("[for=gender-radio-2]")).click();
        driver.findElement(By.id("userNumber")).sendKeys("0600706273");
        moveFocusToElement(By.cssSelector("[class='react-datepicker__input-container']")).click();
        driver.findElement(By.cssSelector("[class='react-datepicker__month-select']")).click();
        driver.findElement(By.cssSelector("[value='11']")).click();
        driver.findElement(By.cssSelector("[class='react-datepicker__year-select']")).click();
        driver.findElement(By.cssSelector("[value='1992']")).click();
        driver.findElement(By.cssSelector("[class='react-datepicker__day react-datepicker__day--027 react-datepicker__day--weekend']")).click();
        driver.findElement(By.id("subjects-label")).click();
        waitToBeInteractable(By.id("subjectsInput")).sendKeys("E");
        driver.findElement(By.id("react-select-2-option-0")).click();
        driver.findElement(By.cssSelector("[for='hobbies-checkbox-2']")).click();
        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\Dragana\\IdeaProjects\\selenide-qa\\src\\main\\resources\\margarite.jpg");
        driver.findElement(By.id("currentAddress")).sendKeys("Slanacki put 76l");
        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("react-select-3-option-2")).click();
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("react-select-4-option-1")).click();
        driver.findElement(By.id("submit")).click();
        waitForElementVisibility(By.xpath("//*[text()='Thanks for submitting the form']"));
        driver.close();
    }

    public WebElement waitToBeInteractable(By by, Integer... timeout) {
        int timeToWait = timeout.length > 0 ? timeout[0] : 10;
        return new WebDriverWait(driver, Duration.ofSeconds(timeToWait)).until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitForElementVisibility(By by, Integer... timeout) {
        int timeToWait = timeout.length > 0 ? timeout[0] : 10;
        return new WebDriverWait(driver, Duration.ofSeconds(timeToWait)).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement getElementIfPresent(By by, Integer... timeout) {
        int timeToWait = timeout.length > 0 ? timeout[0] : 10;
        return new WebDriverWait(driver, Duration.ofSeconds(timeToWait)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement moveFocusToElement(By by, Integer... timeout) {
        WebElement element = getElementIfPresent(by, timeout);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

}
