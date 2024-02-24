package org.automation;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @Test
    public void loginTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.findElement(By.id("input-email")).sendKeys("dragana9290@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Bp3nK2@Ek9HdL5J");
        driver.findElement(By.cssSelector("[value='Login']")).click();
        driver.close();
    }


}
