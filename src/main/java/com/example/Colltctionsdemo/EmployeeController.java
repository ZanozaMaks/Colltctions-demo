package com.example.Colltctionsdemo;

import model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import service.EmployeeService;

import java.util.Collection;
import java.util.List;

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
	public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
		return employeeService.add(firstName, lastName);
	}

	@GetMapping("/remove")
	public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
		return employeeService.remove(firstName, lastName);
	}

	@GetMapping("/get")
	public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
		return employeeService.get(firstName, lastName);
	}

	@GetMapping
	public Collection<Employee> getAll() {
		return employeeService.getAll();
	}
}