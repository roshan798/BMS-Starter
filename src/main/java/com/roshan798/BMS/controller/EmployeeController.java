package com.roshan798.BMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roshan798.BMS.dto.EmployeeDTO;
import com.roshan798.BMS.dto.LoginRequest;
import com.roshan798.BMS.model.Employee;
import com.roshan798.BMS.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

//	private EmployeeService
	// remove this
	@GetMapping("/ping")
	protected String ping() {
		return "Emplyee controller ping success";
	}

	@PostMapping("/register")
	protected ResponseEntity<?> registerEmployee(@RequestBody Employee emp) {
		try {
			EmployeeDTO savedEmployee = employeeService.registerEmployee(emp);
			return ResponseEntity.ok().body(savedEmployee);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<Boolean> loginEmployee(@RequestBody LoginRequest loginRequest) {
		long id = loginRequest.getEmployeeId();
		boolean isAuthenticated = employeeService.isAuthenticate(id, loginRequest.getPassword());

		if (isAuthenticated) {
			return ResponseEntity.ok(true);
		} else {
			return ResponseEntity.status(401).body(false);
		}
	}

	@GetMapping("/view-all")
	protected List<EmployeeDTO> viewAll() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/{employeeId}")
	protected ResponseEntity<?> getEmployee(@PathVariable long employeeId) {
		try {
			EmployeeDTO employee = employeeService.getByEmployeeId(employeeId);
			return ResponseEntity.ok(employee);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{employeeId}")
	protected boolean deleteEmployee(@PathVariable long employeeId) {
		return employeeService.deleteByEmployeeId(employeeId);
	}

	@PutMapping("/{employeeId}")
	protected EmployeeDTO updateEmployee(@PathVariable long employeeId, @RequestBody EmployeeDTO employee) {

		return employeeService.updateEmployee(employeeId, employee);
	}
}

// TODO
// send ResponseEntity Object in each request
