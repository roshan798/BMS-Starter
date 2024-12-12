package com.roshan798.BMS.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name = "employees")
public class Employee {

	@Id // makes id the primary key of the employees table
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // this will add the AUTO_INCREMENT
	private int id;

	@Column(nullable = false, unique = true, length = 7)
	// nullable = false empId cannot be null
	// must be unique
	// and length will be 7
	@Setter
	private String employeeId; // 7 digit random id

	@Column(nullable = false, length = 50) // max
	private String name;

	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, length = 30)
	private String password;

	@Column(nullable = true, length = 50)
	private String address;

	@Column(nullable = true, length = 10)
	private String contact;
}
