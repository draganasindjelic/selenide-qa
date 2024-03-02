package org.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static final By FORMS = By.xpath("//h5[text()='Forms']");
    private static final By PRACTICE_FORM = By.xpath("//*[text()='Practice Form']");

    public PracticeFormPage openPracticeFormPage() {
        moveFocusToElement(FORMS).click();
        moveFocusToElement(PRACTICE_FORM).click();
        return new PracticeFormPage(driver);
    }

}
