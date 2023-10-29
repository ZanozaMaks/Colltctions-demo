package com.example.Colltctionsdemo;

import model.Employee;
import org.springframework.web.bind.annotation.*;
import service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam Integer departmentId) {
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam Integer departmentId) {
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping(value = "/all", params = {"departmentId"})
    public Collection<Employee> getEmployee(@RequestParam Integer departmentId){
        return departmentService.getEmployee(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getEmployee(){
        return departmentService.getEmployee();
    }
}
