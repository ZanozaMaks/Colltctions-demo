package service;

import model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(Integer deparmentId);
    Employee getEmployeeWithMinSalary(Integer deparmentId);
    Map<Integer, List<Employee>> getEmployee(Integer deparmentId);

    Map <Integer, List
            <Employee>> getEmployee();
}
