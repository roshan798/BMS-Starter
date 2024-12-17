package com.roshan798.BMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roshan798.BMS.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
//	boolean existsByEmployeeId(String employeeId);
//	boolean deleteByEmployeeId(String employeeId);
}