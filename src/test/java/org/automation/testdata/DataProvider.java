package org.automation.testdata;

import com.github.javafaker.Faker;
import org.automation.model.Employee;

public class DataProvider {

    public static Employee getRandomEmployee() {
        Faker faker = new Faker();
        Employee employee = new Employee();
        employee.setFirstName(faker.name().firstName());
        employee.setLastName(faker.name().lastName());
        employee.setEmail(faker.internet().emailAddress());
        employee.setAge(String.valueOf(faker.number().numberBetween(18, 88)));
        employee.setSalary(String.valueOf(faker.number().numberBetween(500, 5000)));
        employee.setDepartment(faker.commerce().department());
        return employee;
    }

}
