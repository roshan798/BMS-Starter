package com.roshan798.BMS.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true, length = 7)
	private Long employeeId;

	@Column(nullable = false, length = 50)
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
