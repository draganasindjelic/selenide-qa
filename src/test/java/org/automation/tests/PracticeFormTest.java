package org.automation.tests;

import org.automation.pages.HomePage;
import org.automation.pages.PracticeFormPage;
import org.automation.tests.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.automation.utils.SeleniumUtils.waitForElementVisibility;

public class PracticeFormTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        homePage = new HomePage(driver);
    }

    @Test
    public void practiceFormTest() {
        PracticeFormPage practiceFormPage = homePage.openPracticeFormPage();
        practiceFormPage.fillOutPracticeForm();
        practiceFormPage.submitPracticeForm();

        waitForElementVisibility(By.xpath("//*[text()='Thanks for submitting the form']"));
    }

}
