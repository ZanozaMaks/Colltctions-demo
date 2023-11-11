package service;

import exception.EmployeeNotFoundException;
import model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImplement implements DepartmentService{

    private final EmployeeService employeeService;

    public DepartmentServiceImplement(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(Integer deparmentId) {
        return employeeService.getAll().stream().filter( e -> e.getDepartment() == deparmentId)
                .max(Comparator.comparingInt(Employee::getSalary)).orElseThrow(() -> new  EmployeeNotFoundException("Сотрудника с максимальной зарплатой нет"));
    }

    @Override
    public Employee getEmployeeWithMinSalary(Integer deparmentId) {
        return employeeService.getAll().stream().filter( e -> e.getDepartment() == deparmentId)
                .min(Comparator.comparingInt(Employee::getSalary)).orElseThrow(() -> new  EmployeeNotFoundException("Сотрудника с минимальной зарплатой нет"));
    }

    @Override
    public Collection<Employee> getEmployee(Integer deparmentId) {
        return employeeService.getAll().stream().filter( e -> e.getDepartment() == deparmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getEmployee() {
        return employeeService.getAll().stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
