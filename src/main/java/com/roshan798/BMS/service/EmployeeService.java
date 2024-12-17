package com.roshan798.BMS.service;

import java.util.List;

import com.roshan798.BMS.dto.EmployeeDTO;
import com.roshan798.BMS.model.Employee;

public interface EmployeeService {
	public EmployeeDTO registerEmployee(Employee employee);

	boolean loginEmployee(long employeeId, String password);

	boolean isAuthenticate(long employeeId, String password);

	public List<EmployeeDTO> getAllEmployees();

	EmployeeDTO getByEmployeeId(long employeeId);

	boolean deleteByEmployeeId(long employeeId);

	EmployeeDTO updateEmployee(long employeeId, EmployeeDTO data);
}
