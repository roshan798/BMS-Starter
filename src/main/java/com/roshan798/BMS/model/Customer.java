package com.roshan798.BMS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	private Long ssnId; // 7-digit unique ID (Primary Key)

	private String name;
	private String email;
	// add more fields
}
