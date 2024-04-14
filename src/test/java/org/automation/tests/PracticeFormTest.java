package org.automation.tests;

import org.automation.pages.HomePage;
import org.automation.pages.PracticeFormPage;
import org.automation.tests.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.automation.utils.SeleniumUtils.waitForElementVisibility;

public class PracticeFormTest extends BaseTest {

    @Test
    public void practiceFormTest() {
        PracticeFormPage practiceFormPage = HomePage.getInstance().openPracticeFormPage();
        practiceFormPage.fillOutPracticeForm();
        practiceFormPage.submitPracticeForm();

        waitForElementVisibility(By.xpath("//*[text()='Thanks for submitting the form']"));
    }

}
