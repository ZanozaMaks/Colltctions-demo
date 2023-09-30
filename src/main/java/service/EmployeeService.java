package service;
import com.example.Colltctionsdemo.EmployeeController;
import exception.EmployeeAlreadyAddedException;
import exception.EmployeeNotFoundException;
import exception.EmployeeStorageIsFullException;
import model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService {

    private static final int MAX_SIZE = 5;
    private final List<Employee> employees = new ArrayList<>();

    public Employee add(String firstName, String lastName) {

        if (employees.size() > MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переополнен.");
        }

        Employee newEmployee = new Employee(firstName, lastName);

        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть.");
        }

        employees.add(newEmployee);

        return newEmployee;
    }

    public Employee remove(String firstName, String lastName) {
        Employee employeeForRemove = new Employee(firstName, lastName);

        if (!employees.contains(employeeForRemove)) {
            throw new EmployeeNotFoundException("Невозможно удалить. Такого сотрудника не существует.");
        }

        employees.remove(employeeForRemove);
        return employeeForRemove;
    }

    public Employee get(String firstName, String lastName) {
        Employee employeeForSearch = new Employee(firstName, lastName);

        if (!employees.contains(employeeForSearch)) {
            throw new EmployeeNotFoundException("Такого сотрудника не существует.");
        }

        Employee result = null;
        for (Employee employee : employees) {
            if (employee.equals(employeeForSearch)) {
                return employee;
            }
        }
        return result;
    }

    public List<Employee> getAll() {
        return employees;
    }
}