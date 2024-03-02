package org.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    private static final By FIRSTNAME_INPUT = By.id("firstName");
    private static final By LASTNAME_INPUT = By.id("lastName");
    private static final By EMAIL_INPUT = By.id("userEmail");
    private static final By RADIO_INPUT = By.cssSelector("[for=gender-radio-2]");
    private static final By USER_NUMBER_INPUT = By.id("userNumber");
    private static final By CALENDAR = By.cssSelector("[class='react-datepicker__input-container']");
    private static final By MONTH_SELECT = By.cssSelector("[class='react-datepicker__month-select']");
    private static final By VALUE_OF_MONTH_SELECT = By.cssSelector("[value='11']");
    private static final By YEAR_SELECT = By.cssSelector("[class='react-datepicker__year-select']");
    private static final By VALUE_OF_YEAR_SELECT = By.cssSelector("[value='1992']");
    private static final By DAY_SELECT = By.cssSelector("[class='react-datepicker__day react-datepicker__day--027 react-datepicker__day--weekend']");
    private static final By SUBJECT_LABEL = By.id("subjects-label");
    private static final By SUBJECT_LABEL_INPUT = By.id("subjectsInput");
    private static final By SELECT_LABEL = By.xpath("//div[contains(@class, 'subjects-auto-complete__option') and contains(text(), 'English')]");
    private static final By SELECT_HOBBIES = By.cssSelector("[for='hobbies-checkbox-2']");
    private static final By UPLOAD_PICTURE = By.id("uploadPicture");
    private static final By CURRENT_ADRESS = By.id("currentAddress");
    private static final By STATE = By.id("state");
    private static final By SELECT_STATE = By.id("react-select-3-option-2");
    private static final By CITY = By.id("city");
    private static final By SELECT_CITY = By.id("react-select-4-option-1");
    private static final By SUBMIT = By.id("submit");

    public void fillOutPracticeForm() {
        driver.findElement(FIRSTNAME_INPUT).sendKeys("Dragana");
        driver.findElement(LASTNAME_INPUT).sendKeys("Sindjelic");
        driver.findElement(EMAIL_INPUT).sendKeys("dragana9290@gmail.com");
        moveFocusToElement(RADIO_INPUT);
        waitForElementVisibility(RADIO_INPUT).click();
        driver.findElement(USER_NUMBER_INPUT).sendKeys("0600706273");
        moveFocusToElement(CALENDAR).click();
        driver.findElement(MONTH_SELECT).click();
        driver.findElement(VALUE_OF_MONTH_SELECT).click();
        driver.findElement(YEAR_SELECT).click();
        driver.findElement(VALUE_OF_YEAR_SELECT).click();
        driver.findElement(DAY_SELECT).click();
        driver.findElement(SUBJECT_LABEL).click();
        moveFocusToElement(SUBJECT_LABEL_INPUT);
        waitToBeInteractable(SUBJECT_LABEL_INPUT).sendKeys("E");
        moveFocusToElement(SELECT_LABEL).click();
        driver.findElement(SELECT_HOBBIES).click();
        driver.findElement(UPLOAD_PICTURE).sendKeys("C:\\Users\\Dragana\\IdeaProjects\\selenide-qa\\src\\main\\resources\\margarite.jpg");
        driver.findElement(CURRENT_ADRESS).sendKeys("Slanacki put 76l");
        moveFocusToElement(STATE).click();
        driver.findElement(SELECT_STATE).click();
        driver.findElement(CITY).click();
        driver.findElement(SELECT_CITY).click();
    }

    public void submitPracticeForm() {
        driver.findElement(SUBMIT).click();
    }

}
