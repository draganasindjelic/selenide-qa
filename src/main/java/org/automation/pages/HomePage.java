package org.automation.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private static final By FORMS = By.xpath("//h5[text()='Forms']");
    private static final By PRACTICE_FORM = By.xpath("//*[text()='Practice Form']");
    private static final By ELEMENTS = By.xpath("//h5[text()='Elements']");
    private static final By WEB_TABLES = By.xpath("//*[text()='Web Tables']");

    public static HomePage getInstance() {
        return new HomePage();
    }

    public PracticeFormPage openPracticeFormPage() {
        moveFocusToElement(FORMS).click();
        moveFocusToElement(PRACTICE_FORM).click();
        return new PracticeFormPage();
    }

    public WebTablesPage openWebTablesPage() {
        moveFocusToElement(ELEMENTS).click();
        moveFocusToElement(WEB_TABLES).click();
        return new WebTablesPage();
    }

}
