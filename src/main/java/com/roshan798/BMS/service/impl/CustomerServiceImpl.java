package com.roshan798.BMS.service.impl;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roshan798.BMS.dto.CustomerDTO;
import com.roshan798.BMS.model.Customer;
import com.roshan798.BMS.repository.CustomerRepo;
import com.roshan798.BMS.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	private final Random random = new Random();

	// Generate a 7-digit unique SSN ID
	private Long generateUniqueSsnId() {
		Long ssnId;
		do {
			ssnId = 1000000L + random.nextInt(9000000); // Generate 7-digit number
		} while (customerRepo.existsById(ssnId)); // Check for uniqueness
		return ssnId;
	}

	@Override
	public CustomerDTO registerCustomer(CustomerDTO customerDTO) {
		Long ssnId = generateUniqueSsnId();

		Customer customer = new Customer();
		customer.setSsnId(ssnId);
		customer.setName(customerDTO.getName());
		customer.setEmail(customerDTO.getEmail());

		Customer savedCustomer = customerRepo.save(customer);
		return new CustomerDTO(savedCustomer);
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> customers = customerRepo.findAll();
		return customers.stream().map(CustomerDTO::new).collect(Collectors.toList());
	}

	@Override
	public CustomerDTO getCustomerById(Long ssnId) {
		Customer customer = customerRepo.findById(ssnId)
				.orElseThrow(() -> new RuntimeException("Customer not found with SSN ID: " + ssnId));
		return new CustomerDTO(customer);
	}

	@Override
	public CustomerDTO updateCustomer(Long ssnId, CustomerDTO customerDTO) {
		Customer existingCustomer = customerRepo.findById(ssnId)
				.orElseThrow(() -> new RuntimeException("Customer not found with SSN ID: " + ssnId));

		if (customerDTO.getName() != null) {
			existingCustomer.setName(customerDTO.getName());
		}
		if (customerDTO.getEmail() != null) {
			existingCustomer.setEmail(customerDTO.getEmail());
		}

		Customer updatedCustomer = customerRepo.save(existingCustomer);
		return new CustomerDTO(updatedCustomer);
	}

	@Override
	public boolean deleteCustomer(Long ssnId) {
		if (customerRepo.existsById(ssnId)) {
			customerRepo.deleteById(ssnId);
			return true;
		}
		return false;
	}
}
