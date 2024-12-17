package com.roshan798.BMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roshan798.BMS.dto.CustomerDTO;
import com.roshan798.BMS.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// Simple ping endpoint
	@GetMapping("/ping")
	protected String ping() {
		return "Customer controller ping success";
	}

	// Register a new customer
	@PostMapping("/register")
	protected ResponseEntity<?> registerCustomer(@RequestBody CustomerDTO customerDTO) {
		try {
			CustomerDTO savedCustomer = customerService.registerCustomer(customerDTO);
			return ResponseEntity.ok(savedCustomer);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Get all customers
	@GetMapping("/view-all")
	protected ResponseEntity<List<CustomerDTO>> viewAllCustomers() {
		List<CustomerDTO> customers = customerService.getAllCustomers();
		return ResponseEntity.ok(customers);
	}

	// Get a single customer by SSN ID
	@GetMapping("/{ssnId}")
	protected ResponseEntity<?> getCustomerById(@PathVariable Long ssnId) {
		try {
			CustomerDTO customerDTO = customerService.getCustomerById(ssnId);
			return ResponseEntity.ok(customerDTO);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	// Update a customer by SSN ID
	@PutMapping("/{ssnId}")
	protected ResponseEntity<?> updateCustomer(@PathVariable Long ssnId, @RequestBody CustomerDTO customerDTO) {
		try {
			CustomerDTO updatedCustomer = customerService.updateCustomer(ssnId, customerDTO);
			return ResponseEntity.ok(updatedCustomer);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	// Delete a customer by SSN ID
	@DeleteMapping("/{ssnId}")
	protected ResponseEntity<?> deleteCustomer(@PathVariable Long ssnId) {
		boolean isDeleted = customerService.deleteCustomer(ssnId);
		if (isDeleted) {
			return ResponseEntity.ok("Customer deleted successfully!");
		} else {
			return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
		}
	}
}
