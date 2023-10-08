package service;

import model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(Integer deparmentId);
    Employee getEmployeeWithMinSalary(Integer deparmentId);
    Collection<Employee> getEmployee(Integer deparmentId);

    Map <Integer, List
            <Employee>> getEmployee();
}
