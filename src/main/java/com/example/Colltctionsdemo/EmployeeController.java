package com.example.Colltctionsdemo;

import model.Employee;
import org.springframework.web.bind.annotation.*;
import service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@ExceptionHandler(RuntimeException.class)
	public String handleException(RuntimeException e) {
		return e.getMessage();
	}

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/add")
	public Employee add(@RequestParam String firstName, @RequestParam String lastName, double salary, int departmentId) {
		return employeeService.add(firstName, lastName, salary, departmentId);
	}

	@GetMapping("/remove")
	public Employee remove(@RequestParam String firstName, @RequestParam String lastName, double salary, int departmentId) {
		return employeeService.remove(firstName, lastName, salary, departmentId);
	}

	@GetMapping("/get")
	public Employee find(@RequestParam String firstName, @RequestParam String lastName, double salary, int departmentId) {
		return employeeService.get(firstName, lastName, salary, departmentId);
	}

	@GetMapping
	public Collection<Employee> getAll() {
		return employeeService.getAll();
	}
}