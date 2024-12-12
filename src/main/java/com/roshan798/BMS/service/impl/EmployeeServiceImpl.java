package com.roshan798.BMS.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roshan798.BMS.model.Employee;
import com.roshan798.BMS.repository.EmployeeRepo;
import com.roshan798.BMS.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepository;

	@Override
	public Employee registerEmployee(Employee employeeDto) {
		System.out.println("employee DTO");
		System.out.println(employeeDto);
		Employee employee = new Employee();
		employee.setName(employeeDto.getName());
		employee.setEmail(employeeDto.getEmail());
		employee.setPassword(employeeDto.getPassword());
		employee.setEmployeeId(String.valueOf((int) (Math.random() * 1_000_000)));
		employee.setAddress(employeeDto.getAddress());
		employee.setContact(employeeDto.getContact());
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public boolean loginEmployee(String id, String password) {
		return employeeRepository.findByEmployeeId(id).map(employee -> employee.getPassword().equals(password))
				.orElse(false);
	}

	@Override
	public boolean authenticate(String employeeId, String password) {
		Optional<Employee> data = employeeRepository.findByEmployeeId(employeeId);
		try {
			Employee employee = data.get();
			return employee != null;
		} catch (Exception e) {
			// TODO: handle exception // NoSuchElementException
			return false;
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
}
