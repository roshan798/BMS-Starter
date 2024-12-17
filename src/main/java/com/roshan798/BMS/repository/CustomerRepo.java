package com.roshan798.BMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roshan798.BMS.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
	boolean existsBySsnId(Long ssnId);
}
