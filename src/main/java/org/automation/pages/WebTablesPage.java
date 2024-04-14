package org.automation.pages;

import com.codeborne.selenide.Selenide;
import org.automation.model.Employee;
import org.openqa.selenium.By;

import static org.automation.driver.DriverManager.getDriver;

public class WebTablesPage extends BasePage {

    private static final By ADD_NEW_RECORD_BUTTON = By.id("addNewRecordButton");
    private static final By FIRSTNAME_INPUT = By.id("firstName");
    private static final By LASTNAME_INPUT = By.id("lastName");
    private static final By USER_EMAIL_INPUT = By.id("userEmail");
    private static final By AGE_INPUT = By.id("age");
    private static final By SALARY_INPUT = By.id("salary");
    private static final By DEPARTMENT_INPUT = By.id("department");
    private static final By SUBMIT = By.id("submit");
    private static final By SEARCH_BOX = By.id("searchBox");
    private static final By EDIT = By.cssSelector("[title='Edit']");
    private static final String employeeXpath = "//div[contains(@class, 'rt-td') and contains(text(), '%s')]";
    private static final By DELETE_EMPLOYEE = By.cssSelector("[title='Delete']");

    public void addDataInWebTables(Employee employee) {
        getDriver().findElement(ADD_NEW_RECORD_BUTTON).click();
        getDriver().findElement(FIRSTNAME_INPUT).sendKeys(employee.getFirstName());
        getDriver().findElement(LASTNAME_INPUT).sendKeys(employee.getLastName());
        getDriver().findElement(USER_EMAIL_INPUT).sendKeys(employee.getEmail());
        getDriver().findElement(AGE_INPUT).sendKeys(employee.getAge());
        getDriver().findElement(SALARY_INPUT).sendKeys(employee.getSalary());
        getDriver().findElement(DEPARTMENT_INPUT).sendKeys(employee.getDepartment());
        getDriver().findElement(SUBMIT).click();
    }

    public void verifyEmployeeIsInTable(String firstName) {
       findEmployee(firstName);
    }

    public void editEmployeeAgeInWebTables(String employeeName, String age) {
        findEmployee(employeeName);
        moveFocusToElement(EDIT).click();
        getDriver().findElement(AGE_INPUT).clear();
        getDriver().findElement(AGE_INPUT).sendKeys(age);
        getDriver().findElement(SUBMIT).click();
    }

    public void findEmployee(String firstName) {
        getDriver().findElement(SEARCH_BOX).clear();
        getDriver().findElement(SEARCH_BOX).sendKeys(firstName);
        Selenide.sleep(2000);
        By element = By.xpath(String.format(employeeXpath, firstName));
        getDriver().findElement(element).isDisplayed();
    }

    public String getEmployeeAge(String firstName) {
        By element = By.xpath(String.format("(//div[contains(@class, 'rt-td') and contains(text(), '%s')]/following-sibling::*)[2]", firstName));
        return getDriver().findElement(element).getText();
    }

    public void deleteEmployeeInTable(String firstName) {
        findEmployee(firstName);
        moveFocusToElement(DELETE_EMPLOYEE).click();
    }
}
