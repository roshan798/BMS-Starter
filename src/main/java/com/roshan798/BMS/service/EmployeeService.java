package com.roshan798.BMS.service;

import java.util.List;

import com.roshan798.BMS.model.Employee;

public interface EmployeeService {
	Employee registerEmployee(Employee employee);

	boolean loginEmployee(String email, String password);

	boolean authenticate(String employeeId, String password);

	List<Employee> getAllEmployees();
}
