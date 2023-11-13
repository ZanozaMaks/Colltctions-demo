package service;

import exception.EmployeeAlreadyAddedException;
import exception.EmployeeNotFoundException;
import exception.EmployeeStorageIsFullException;
import model.Employee;
import org.junit.jupiter.api.Test;
import service.utils.EmployeeGenerator;

import static org.junit.jupiter.api.Assertions.*;
import static service.utils.EmployeeGenerator.*;

class EmployeeServiceTest {

    private final EmployeeService employeeService = new EmployeeService();

    @Test
    void add_success() {
        //Подготовка входных данных
        String firstName = FIRST_NAME;
        String lastName = LAST_NAME;
        double salary = SALARY;
        int departmentId = DEPARTMENT_ID;
        //Подготовка ожидаемого результата
        Employee expectedEmployee = getEmployee();
        employeeService.add(firstName, lastName, salary, departmentId);
        //Начало теста
        Employee actualEmployee = employeeService.add(firstName, lastName, salary, departmentId);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void add_EmployeeStorageIsFullException() {
        //Подготовка входных данных
        String firstName = FIRST_NAME;
        String lastName = LAST_NAME;
        double salary = SALARY;
        int departmentId = DEPARTMENT_ID;

        String firstName_1 = FIRST_NAME_1;
        String lastName_1 = LAST_NAME_1;
        double salary_1 = SALARY_1;
        int departmentId_1 = DEPARTMENT_ID_1;

        String firstName_2 = FIRST_NAME_2;
        String lastName_2 = LAST_NAME_2;
        double salary_2 = SALARY_2;
        int departmentId_2 = DEPARTMENT_ID_2;

        String firstName_3 = FIRST_NAME_3;
        String lastName_3 = LAST_NAME_3;
        double salary_3 = SALARY_3;
        int departmentId_3 = DEPARTMENT_ID_3;

        String firstName_4 = FIRST_NAME_4;
        String lastName_4 = LAST_NAME_4;
        double salary_4 = SALARY_4;
        int departmentId_4 = DEPARTMENT_ID_4;

        //Подготовка ожидаемого результата
        String expectedMessage = "Массив сотрудников переполнен.";

        // Начало теста
        employeeService.add(firstName, lastName, salary, departmentId);
        employeeService.add(firstName_1, lastName_1, salary_1, departmentId_1);
        employeeService.add(firstName_2, lastName_2, salary_2, departmentId_2);
        employeeService.add(firstName_3, lastName_3, salary_3, departmentId_3);
        employeeService.add(firstName_4, lastName_4, salary_4, departmentId_4);
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.get(firstName, lastName, salary, departmentId));
        assertEquals(expectedMessage, expectedMessage);


    }

    @Test
    void add_EmployeeAlreadyAdded() {
        //Подготовка входных данных
        String firstName = FIRST_NAME;
        String lastName = LAST_NAME;
        double salary = SALARY;
        int departmentId = DEPARTMENT_ID;

        //Подготовка ожидаемого результата
        String expectedMessage = "Такой сотрудник уже есть.";

        //Начало теста
        employeeService.add(firstName, lastName, salary, departmentId);
        Exception exception = assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add(firstName, lastName, salary, departmentId));
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.get(firstName, lastName, salary, departmentId));
        assertEquals(expectedMessage, expectedMessage);


    }


    @Test
    void remove_success() {
        //Подготовка входных данных
        String firstName = FIRST_NAME;
        String lastName = LAST_NAME;
        double salary = SALARY;
        int departmentId = DEPARTMENT_ID;

        //Подготовка ожидаемого результата
        Employee expectedEmployee = new Employee(firstName, lastName, salary, departmentId);
        employeeService.add(firstName, lastName, salary, departmentId);
        //Начало теста
        Employee actualEmployee = employeeService.remove(firstName, lastName, salary, departmentId);
        assertEquals(expectedEmployee, actualEmployee);

    }

    @Test
    void remove_EmployeeNotFoundException() {
        //подготовка входных данных
        String firstName = FIRST_NAME;
        String lastName = LAST_NAME;
        double salary = SALARY;
        int departmentId = DEPARTMENT_ID;

        //подготовка ожидаемого результата
        String expectedEmployee = "Невозможно удалить. Такого сотрудника не существует.";

        //начало теста
        Employee actualEmployee = employeeService.remove(firstName, lastName, salary, departmentId);
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.get(firstName, lastName, salary, departmentId));
        assertEquals(expectedEmployee, actualEmployee);


    }

    @Test
    void get_success() {
        //Подготовка входных данных
        String firstName = FIRST_NAME;
        String lastName = LAST_NAME;
        double salary = SALARY;
        int departmentId = DEPARTMENT_ID;

        //Подготовка ожидаемого результата
        Employee expectedEmployee = new Employee(firstName, lastName, salary, departmentId);
        employeeService.add(firstName, lastName, salary, departmentId);

        //Начало теста
        Employee actualEmployee = employeeService.get(firstName, lastName, salary, departmentId);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void get_EmployeeNotFoundException() {
        //Подготовка входных данных
        String firstName = FIRST_NAME;
        String lastName = LAST_NAME;
        double salary = SALARY;
        int departmentId = DEPARTMENT_ID;

        //Подготовка ожидаемого результата
        String expectedEmployee = "Такого сотрудника не существует.";

        //Начало теста
        employeeService.get(firstName, lastName, salary, departmentId);
        Employee actualEmployee = employeeService.get(firstName, lastName, salary, departmentId);
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.get(firstName, lastName, salary, departmentId));
        assertEquals(expectedEmployee, actualEmployee);

    }

    @Test
    void getAll_success() {

        //подготовка входных данных
        String firstName = FIRST_NAME;
        String lastName = LAST_NAME;
        double salary = SALARY;
        int departmentId = DEPARTMENT_ID;

        String firstName_1 = FIRST_NAME_1;
        String lastName_1 = LAST_NAME_1;
        double salary_1 = SALARY_1;
        int departmentId_1 = DEPARTMENT_ID_1;

        String firstName_2 = FIRST_NAME_2;
        String lastName_2 = LAST_NAME_2;
        double salary_2 = SALARY_2;
        int departmentId_2 = DEPARTMENT_ID_2;

        String firstName_3 = FIRST_NAME_3;
        String lastName_3 = LAST_NAME_3;
        double salary_3 = SALARY_3;
        int departmentId_3 = DEPARTMENT_ID_3;

        String firstName_4 = FIRST_NAME_4;
        String lastName_4 = LAST_NAME_4;
        double salary_4 = SALARY_4;
        int departmentId_4 = DEPARTMENT_ID_4;

        //подготовка ожидаемого результата
        Employee expectedEmployee = new Employee(firstName, lastName, salary, departmentId);
        employeeService.add(firstName, lastName, salary, departmentId);

        //начало теста
        Employee actualEmployee = employeeService.get(firstName, lastName, salary, departmentId);


        employeeService.add(firstName, lastName, salary, departmentId);
        employeeService.add(firstName_1, lastName_1, salary_1, departmentId_1);
        employeeService.add(firstName_2, lastName_2, salary_2, departmentId_2);
        employeeService.add(firstName_3, lastName_3, salary_3, departmentId_3);
        employeeService.add(firstName_4, lastName_4, salary_4, departmentId_4);
        assertEquals(expectedEmployee, actualEmployee);

    }
}