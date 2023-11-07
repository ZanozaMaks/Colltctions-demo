package service;
import exception.EmployeeAlreadyAddedException;
import exception.EmployeeNotFoundException;
import exception.EmployeeStorageIsFullException;
import exception.ValidateException;
import model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class EmployeeService {

    private static final int MAX_SIZE = 5;
    private final Map<String,Employee> employees = new HashMap<>();

    public Employee add(String firstName, String lastName, double salary, int departmentId) {

        firstName = StringUtils.capitalize(firstName);

        lastName = StringUtils.capitalize(lastName);



        validateFirstAndLastName(firstName, lastName);

        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переополнен.");
        }

        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть.");

        }

        Employee newEmployee = new Employee(firstName, lastName, salary, departmentId);

        employees.put(key,newEmployee);

        return newEmployee;
    }

    public Employee remove(String firstName, String lastName, double salary, int departmentId) {

        firstName = StringUtils.capitalize(firstName);

        lastName = StringUtils.capitalize(lastName);

        validateFirstAndLastName(firstName, lastName);

        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Невозможно удалить. Такого сотрудника не существует.");
        }
        Employee employeeForRemove = employees.get(key);

        employees.remove(key);
        return employeeForRemove;
    }


    public Employee get(String firstName, String lastName, double salary, int departmentId) {

        firstName = StringUtils.capitalize(firstName);

        lastName = StringUtils.capitalize(lastName);

        validateFirstAndLastName(firstName, lastName);

        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Такого сотрудника не существует.");
        }
        return employees.get(key);
    }

    private void validateFirstAndLastName(String firstName, String lastName) {
        if (!StringUtils.isAlpha(firstName)) {
            throw new ValidateException("Имя содержит запрещённые символы");
        }

        if (!StringUtils.isAlpha(lastName)) {
            throw new ValidateException("Фамилия содержит запрещённые символы");
        }
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }
    private String getKey (String firstName, String lastName) {
        return firstName + lastName;
    }
}

//