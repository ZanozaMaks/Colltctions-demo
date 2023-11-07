package service;

import exception.EmployeeAlreadyAddedException;
import exception.EmployeeStorageIsFullException;
import model.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    private final EmployeeService employeeService = new EmployeeService();

    @Test
    void add_success() {
        //Подготовка входных данных
        String firstName = "Максим";
        String lastName = "Заноза";
        double salary = 70000;
        int departmentId = 1;
        //Подготовка ожидаемого результата
        Employee expectedEmployee = new Employee(firstName, lastName, salary, departmentId);
        //Начало теста
        Employee actualEmployee = employeeService.add(firstName, lastName, salary, departmentId);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void add_EmployeeStorageIsFullException() {
        //Подготовка входных данных
        String firstName = "Максим";
        String lastName = "Заноза";
        double salary = 70000;
        int departmentId = 1;

        String firstName_1 = "Никита";
        String lastName_1 = "Жигулин";
        double salary_1 = 55000;
        int departmentId_1 = 1;

        String firstName_2 = "Никита";
        String lastName_2 = "Щепкин";
        double salary_2 = 65000;
        int departmentId_2 = 1;

        String firstName_3 = "Иван";
        String lastName_3 = "Кручинкин";
        double salary_3 = 68000;
        int departmentId_3 = 1;

        String firstName_4 = "Илья";
        String lastName_4 = "Мазанов";
        double salary_4 = 57000;
        int departmentId_4 = 1;

        //Подготовка ожидаемого результата
        String expectedMessage = "Массив сотрудников переополнен.";

        // Начало теста
        employeeService.add(firstName, lastName, salary, departmentId);
        employeeService.add(firstName_1, lastName_1, salary_1, departmentId_1);
        employeeService.add(firstName_2, lastName_2, salary_2, departmentId_2);
        employeeService.add(firstName_3, lastName_3, salary_3, departmentId_3);
        employeeService.add(firstName_4, lastName_4, salary_4, departmentId_4);
        Exception exception = assertThrows(EmployeeStorageIsFullException.class, () -> employeeService.add(firstName, lastName, salary, departmentId));
        assertEquals(expectedMessage, expectedMessage);
    }

    @Test
    void add_EmployeeAlreadyAdded() {
        //Подготовка входных данных
        String firstName = "Максим";
        String lastName = "Заноза";
        double salary = 70000;
        int departmentId = 1;

        //Подготовка ожидаемого результата
        String expectedMessage = "Такой сотрудник уже есть.";

        //Начало теста
        employeeService.add(firstName, lastName, salary, departmentId);
        Exception exception = assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add(firstName, lastName, salary, departmentId));
        assertEquals(expectedMessage, expectedMessage);

    }


    @Test
    void remove_success() {
        //Подготовка входных данных
        String firstName = "Максим";
        String lastName = "Заноза";
        double salary = 70000;
        int departmentId = 1;

        //Подготовка ожидаемого результата
        Employee expectedEmployee = new Employee(firstName, lastName, salary, departmentId);

        //Начало теста
        Employee actualEmployee = employeeService.remove(firstName, lastName, salary, departmentId);
        assertEquals(expectedEmployee, actualEmployee);

    }

    @Test
    void remove_EmployeeNotFoundException() {
        //подготовка входных данных
        String firstName = "Максим";
        String lastName = "Заноза";
        double salary = 70000;
        int departmentId = 1;

        //подготовка ожидаемого результата
        String expectedEmployee = "Невозможно удалить. Такого сотрудника не существует.";

        //начало теста
        Employee actualEmployee = employeeService.remove(firstName, lastName, salary, departmentId);
        assertEquals(expectedEmployee, actualEmployee);

    }

    @Test
    void get_success() {
        //Подготовка входных данных
        String firstName = "Максим";
        String lastName = "Заноза";
        double salary = 70000;
        int departmentId = 1;

        //Подготовка ожидаемого результата
        Employee expectedEmployee = new Employee(firstName, lastName, salary, departmentId);

        //Начало теста
        employeeService.get(firstName, lastName, salary, departmentId);
        Employee actualEmployee = employeeService.get(firstName, lastName, salary, departmentId);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void get_EmployeeNotFoundException() {
        //Подготовка входных данных
        String firstName = "Максим";
        String lastName = "Заноза";
        double salary = 70000;
        int departmentId = 1;

        //Подготовка ожидаемого результата
        String expectedEmployee = "Такого сотрудника не существует.";

        //Начало теста
        employeeService.get(firstName, lastName, salary, departmentId);
        Employee actualEmployee = employeeService.get(firstName, lastName, salary, departmentId);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void getAll_success() {

        //подготовка входных данных
        String firstName = "Максим";
        String lastName = "Заноза";
        double salary = 70000;
        int departmentId = 1;

        String firstName_1 = "Никита";
        String lastName_1 = "Жигулин";
        double salary_1 = 55000;
        int departmentId_1 = 1;

        String firstName_2 = "Никита";
        String lastName_2 = "Щепкин";
        double salary_2 = 65000;
        int departmentId_2 = 1;

        String firstName_3 = "Иван";
        String lastName_3 = "Кручинкин";
        double salary_3 = 68000;
        int departmentId_3 = 1;

        String firstName_4 = "Илья";
        String lastName_4 = "Мазанов";
        double salary_4 = 57000;
        int departmentId_4 = 1;

        //подготовка ожидаемого результата


        //начало теста

    }
}