package com.roshan798.BMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roshan798.BMS.dto.LoginRequest;
import com.roshan798.BMS.model.Employee;
import com.roshan798.BMS.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

//	private EmployeeService
	@GetMapping("/ping")
	protected String ping() {
		return "Emplyee controller ping success";
	}

	@PostMapping("/register")
	protected ResponseEntity<Employee> registerEmployee(@RequestBody Employee emp) {
		System.out.println("Employee recieved at register Employee controller");
		System.out.println(emp);
		Employee savedEmployee = employeeService.registerEmployee(emp);
		return ResponseEntity.ok().body(savedEmployee);
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginEmployee(@RequestBody LoginRequest loginRequest) {
		boolean isAuthenticated = employeeService.authenticate(loginRequest.getEmployeeId(),
				loginRequest.getPassword());
		if (isAuthenticated) {
			return ResponseEntity.ok("Login successful!");
		} else {
			return ResponseEntity.status(401).body("Invalid credentials");
		}
	}

	@GetMapping("/view-all")
	protected List<Employee> viewAll() {
		return employeeService.getAllEmployees();
	}

}
