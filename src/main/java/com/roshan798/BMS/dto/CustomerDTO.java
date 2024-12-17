package com.roshan798.BMS.dto;

import com.roshan798.BMS.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
	private long ssnId;
	private String name;
	private String email;

	public CustomerDTO(Customer customer) {
		this.ssnId = customer.getSsnId();
		this.name = customer.getName();
		this.email = customer.getEmail();
	}
}
