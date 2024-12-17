package com.roshan798.BMS.dto;

import java.util.ArrayList;
import java.util.List;

import com.roshan798.BMS.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	private long employeeId;
	private String name;
	private String email;
	private String address;
	private String contact;

	public EmployeeDTO(Employee employee) {
		this.employeeId = employee.getEmployeeId();
		this.name = employee.getName();
		this.email = employee.getEmail();
		this.address = employee.getAddress();
		this.contact = employee.getAddress();
	}

	public static List<EmployeeDTO> employeeListToDTO(List<Employee> emp) {
		List<EmployeeDTO> employees = new ArrayList<>();
		for (Employee e : emp) {
			employees.add(new EmployeeDTO(e));
		}
		return employees;
	}
}
