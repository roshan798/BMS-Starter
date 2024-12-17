package com.roshan798.BMS.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roshan798.BMS.dto.EmployeeDTO;
import com.roshan798.BMS.model.Employee;
import com.roshan798.BMS.repository.EmployeeRepo;
import com.roshan798.BMS.service.EmployeeService;

import exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepository;

	private final Random random = new Random();

	@Override
	public EmployeeDTO registerEmployee(Employee data) {
		Long uniqueId = generateUniqueId();
		Employee employee = new Employee(uniqueId, data.getName(), data.getEmail(), data.getPassword(),
				data.getAddress(), data.getContact());
//		System.out.println(employee);
		Employee savedEmployeeData = employeeRepository.save(employee);
//		System.out.println("saved + " + savedEmployeeData);

		return new EmployeeDTO(savedEmployeeData);
	}

	private Long generateUniqueId() {
		Long id;
		do {
			id = generateRandom7DigitNumber();
		} while (employeeRepository.existsById(id));
		return id;
	}

	private Long generateRandom7DigitNumber() {
		return 1000000L + random.nextInt(9000000); // 7 digits
	}

	@Override
	public boolean loginEmployee(long id, String password) throws EmployeeNotFoundException {
		boolean status = employeeRepository.findById(id).map(employee -> employee.getPassword().equals(password))
				.orElse(false);
		if (status) {
			return status;
		} else {
			return false;
		}
	}

	@Override
	public boolean isAuthenticate(long employeeId, String password) {
		Optional<Employee> data = employeeRepository.findById(employeeId);
		try {
			Employee employee = data.get();
			return employee != null;
		} catch (Exception e) {
			// TODO: handle exception // NoSuchElementException
			return false;
		}
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return EmployeeDTO.employeeListToDTO(employees);
	}

	@Override
	public EmployeeDTO getByEmployeeId(long employeeId) throws EmployeeNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + employeeId));
		return new EmployeeDTO(employee);
	}

	@Override
	public boolean deleteByEmployeeId(long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + employeeId));
		employeeRepository.delete(employee);
		return true;
	}

	@Override
	public EmployeeDTO updateEmployee(long employeeId, EmployeeDTO data) {
		// Fetch existing employee or return null if not found
		Employee employee = employeeRepository.findById(employeeId).orElse(null);
		if (employee == null) {
			return null;
		}

		// (excluding password and id)
		if (data.getName() != null) {
			employee.setName(data.getName());
		}
		if (data.getEmail() != null) {
			employee.setEmail(data.getEmail());
		}
		if (data.getAddress() != null) {
			employee.setAddress(data.getAddress());
		}
		if (data.getContact() != null) {
			employee.setContact(data.getContact());
		}
		// Save the updated entity
		Employee updatedEmployee = employeeRepository.save(employee);

		// Return the updated DTO
		return new EmployeeDTO(updatedEmployee);
	}

}
