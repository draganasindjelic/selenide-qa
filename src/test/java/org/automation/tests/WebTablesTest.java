package org.automation.tests;

import com.github.javafaker.Faker;
import org.automation.model.Employee;
import org.automation.pages.HomePage;
import org.automation.pages.WebTablesPage;
import org.automation.tests.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.automation.testdata.DataProvider.getRandomEmployee;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class WebTablesTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("doSomethingArgsProvider")
    public void addAndEditEmployeeTest(Employee employee) {
        WebTablesPage webTablesPage = HomePage.getInstance().openWebTablesPage();
        webTablesPage.addDataInWebTables(employee);
        webTablesPage.verifyEmployeeIsInTable(employee.getFirstName());
        Faker faker = new Faker();
        String newAge = String.valueOf(faker.number().numberBetween(18, 88));
        webTablesPage.editEmployeeAgeInWebTables(employee.getFirstName(), newAge);
        Assertions.assertEquals(newAge, webTablesPage.getEmployeeAge(employee.getFirstName()));
    }

    @Test
    public void deleteEmployeeTest() {
        WebTablesPage webTablesPage = HomePage.getInstance().openWebTablesPage();
        webTablesPage.deleteEmployeeInTable("Alden");
    }

    static Stream<Arguments> doSomethingArgsProvider() {
        return Stream.of(
                arguments(getRandomEmployee()),
                arguments(getRandomEmployee())
        );
    }

}
