package org.automation;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddressBookTest {

    @Test
    @Tag(value = "opencart")
    public void addressBookTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.findElement(By.id("input-email")).sendKeys("dragana9290@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Bp3nK2@Ek9HdL5J");
        driver.findElement(By.cssSelector("[value='Login']")).click();
        driver.findElement(By.xpath("//a[text()='Address Book']")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'New Address')]")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Dragana");
        driver.findElement(By.id("input-lastname")).sendKeys("Sindjelic");
        driver.findElement(By.id("input-address-1")).sendKeys("Slanacki put 76l");
        driver.findElement(By.id("input-city")).sendKeys("Beograd");
        driver.findElement(By.id("input-postcode")).sendKeys("11000");

        WebElement selectCountry = driver.findElement(By.id("input-country"));
        Select select = new Select(selectCountry);
        select.selectByValue("243");

        Selenide.sleep(2000);

        WebElement selectState = driver.findElement(By.id("input-zone"));
        Select selectRegion = new Select(selectState);
        selectRegion.selectByVisibleText("Belgrade");

        driver.findElement(By.cssSelector("[type='submit']")).click();
    }

}
