package service;

import exception.EmployeeNotFoundException;
import model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.utils.EmployeeGenerator.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static service.utils.EmployeeGenerator.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplementTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImplement departmentServiceImplement;

    @Test
    void getEmployeeWithMaxSalary_success() {

        //подготовка входных данных
        Integer departmentId = DEPARTMENT_ID;

        //подготовка ожидаемого результата
        when(employeeService.getAll()).thenReturn(getAllEmployee());
        Employee expectedEmployee = getEmployee();

        //начало теста
        Employee actualEmployee = departmentServiceImplement.getEmployeeWithMaxSalary(departmentId);
        assertEquals(getEmployee(),actualEmployee);

    }
    @Test
    void getEmployeeWithMaxSalary_withEmployeeNotFoundException() {

        //подготовка входных данных
        Integer departmentId = DEPARTMENT_ID;

        //подготовка ожидаемого результата
        when(employeeService.getAll()).thenReturn(Collections.emptyList());
        String expectedMessage = "Сотрудника с максимальной зарплатой нет";

        //начало теста
        Exception exception = assertThrows(EmployeeNotFoundException.class,() -> departmentServiceImplement.getEmployeeWithMaxSalary(departmentId));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void getEmployeeWithMinSalary_success() {

        //подготовка входных данных
        Integer departmentId = DEPARTMENT_ID;

        //подготовка ожидаемого результата
        when(employeeService.getAll()).thenReturn(getAllEmployee());
        Employee expectedEmployee = getEmployee_1();

        //начало теста
        Employee actualEmployee = departmentServiceImplement.getEmployeeWithMinSalary(departmentId);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void getEmployeeWithMinSalary_withEmployeeNotFoundException() {

        //подготовка входных данных
        Integer departmentId = DEPARTMENT_ID;

        //подготовка ожидаемого результата
        when(employeeService.getAll()).thenReturn(Collections.emptyList());
        String expectedMessage = "Сотрудника с минимальной зарплатой нет";

        //начало теста
        Exception exception = assertThrows(EmployeeNotFoundException.class,() -> departmentServiceImplement.getEmployeeWithMinSalary(departmentId));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    //department
    void getEmployee_success() {

        //подготовка входных данных
        Integer departmentId = DEPARTMENT_ID;

        //подготовка ожидаемого результата
        when(employeeService.getAll()).thenReturn(getAllEmployee());
        Map<Integer ,List<Employee>> expectedMap = new HashMap<>();
        expectedMap.put(DEPARTMENT_ID, Arrays.asList(getEmployee(),getEmployee_1()));

        //начало теста
        Map<Integer, List<Employee>> actualMap = departmentServiceImplement.getEmployee(departmentId);
        assertEquals(expectedMap, actualMap);


    }

    @Test
    //department
    void getEmployee_withDepartmentIsNull() {

        //подготовка входных данных
        Integer departmentId = null;

        //подготовка ожидаемого результата
        when(employeeService.getAll()).thenReturn(getAllEmployee());
        Map<Integer ,List<Employee>> expectedMap = new HashMap<>();
        expectedMap.put(DEPARTMENT_ID, Arrays.asList(getEmployee(),getEmployee_1()));
        expectedMap.put(DEPARTMENT_ID, Collections.singletonList(getEmployee_2()));

        //начало теста
        Map<Integer, List<Employee>> actualMap = (Map<Integer, List<Employee>>) departmentServiceImplement.getEmployee();
        assertEquals(expectedMap, actualMap);

    }
}