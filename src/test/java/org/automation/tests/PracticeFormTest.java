package org.automation.tests;

import org.automation.tests.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.automation.driver.DriverManager.getDriver;
import static org.automation.utils.SeleniumUtils.*;

public class PracticeFormTest extends BaseTest {

    @Test
    public void practiceFormTest() {
        getDriver().get("https://demoqa.com/");
        moveFocusToElement(By.xpath("//h5[text()='Forms']")).click();
        getDriver().findElement(By.xpath("//*[text()='Practice Form']")).click();
        getDriver().findElement(By.id("firstName")).sendKeys("Dragana");
        getDriver().findElement(By.id("lastName")).sendKeys("Sindjelic");
        getDriver().findElement(By.id("userEmail")).sendKeys("dragana9290@gmail.com");
        moveFocusToElement(By.cssSelector("[for=gender-radio-2]"));
        waitForElementVisibility(By.cssSelector("[for=gender-radio-2]")).click();
        getDriver().findElement(By.id("userNumber")).sendKeys("0600706273");
        moveFocusToElement(By.cssSelector("[class='react-datepicker__input-container']")).click();
        getDriver().findElement(By.cssSelector("[class='react-datepicker__month-select']")).click();
        getDriver().findElement(By.cssSelector("[value='11']")).click();
        getDriver().findElement(By.cssSelector("[class='react-datepicker__year-select']")).click();
        getDriver().findElement(By.cssSelector("[value='1992']")).click();
        getDriver().findElement(By.cssSelector("[class='react-datepicker__day react-datepicker__day--027 react-datepicker__day--weekend']")).click();
        getDriver().findElement(By.id("subjects-label")).click();
        waitToBeInteractable(By.id("subjectsInput")).sendKeys("E");
        getDriver().findElement(By.id("react-select-2-option-0")).click();
        getDriver().findElement(By.cssSelector("[for='hobbies-checkbox-2']")).click();
        getDriver().findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\Dragana\\IdeaProjects\\selenide-qa\\src\\main\\resources\\margarite.jpg");
        getDriver().findElement(By.id("currentAddress")).sendKeys("Slanacki put 76l");
        getDriver().findElement(By.id("state")).click();
        getDriver().findElement(By.id("react-select-3-option-2")).click();
        getDriver().findElement(By.id("city")).click();
        getDriver().findElement(By.id("react-select-4-option-1")).click();
        getDriver().findElement(By.id("submit")).click();
        waitForElementVisibility(By.xpath("//*[text()='Thanks for submitting the form']"));
    }

}
