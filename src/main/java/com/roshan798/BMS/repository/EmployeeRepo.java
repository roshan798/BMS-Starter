package com.roshan798.BMS.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roshan798.BMS.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	boolean existsByEmployeeId(String employeeId);

	Optional<Employee> findByEmployeeId(String id);
}