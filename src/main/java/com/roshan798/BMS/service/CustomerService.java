package com.roshan798.BMS.service;

import java.util.List;

import com.roshan798.BMS.dto.CustomerDTO;

public interface CustomerService {
	CustomerDTO registerCustomer(CustomerDTO customerDTO);

	List<CustomerDTO> getAllCustomers();

	CustomerDTO getCustomerById(Long ssnId);

	CustomerDTO updateCustomer(Long ssnId, CustomerDTO customerDTO);

	boolean deleteCustomer(Long ssnId);
}
